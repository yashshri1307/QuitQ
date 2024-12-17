import { Component } from '@angular/core';
import { product } from 'src/app/models/Product';
import { supplier } from 'src/app/models/Supplier';
import { AuthService } from 'src/app/services/auth.service';
import { ProductService } from 'src/app/services/product.service';
import { SupplierService } from 'src/app/services/supplier.service';
@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent {
  productList: any[] = [];

  supplier!:supplier;

  constructor(private productService: ProductService,private supplierservice: SupplierService,private authservice:AuthService ) {}

  ngOnInit() {

    this.getSupplierIdAndFetchProducts();
  }

  id!:number;

 

  getSupplierIdAndFetchProducts() {
    const email = this.authservice.getLoggedInEmail();
    this.supplierservice.getSupplierByEmail(email).subscribe(
      (response: supplier) => {
        this.supplier = response; 
        if (this.supplier && this.supplier.supplierId) {
          this.id = this.supplier.supplierId; 

          this.productService.getProductBySupplierId(this.id).subscribe(
            (products) => {
              this.productList = products.map((product: any) => ({
                ...product,
                supplierId: product.supplier.supplierId, 
              }));
            },
            (error) => {
              console.error('Error fetching products:', error);
            }
          );
        } else {
          console.error('Supplier ID not found in response:', response);
        }
      },
      (error) => {
        console.error('Failed to fetch supplier:', error);
      }
    );
  }
  
deleteProduct(productId: number) {
  this.productService.deleteProduct(productId).subscribe(
    () => {
      console.log(`Product with ID ${productId} deleted successfully.`);
      // Refresh product list after deletion
      this.productList = this.productList.filter(product => product.id !== productId);
      
      // Re-fetch the supplier and products after deletion
      this.getSupplierIdAndFetchProducts();
    },
    (error) => {
      console.error(`Error deleting product with ID ${productId}:`, error);
    }
  );
}
}
