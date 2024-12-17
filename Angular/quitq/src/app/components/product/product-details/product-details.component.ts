import { Component } from '@angular/core';
import { product } from 'src/app/models/Product';
import { ProductService } from 'src/app/services/product.service';
@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent {
  productList: any[] = [];

  constructor(private productService: ProductService) {}

  ngOnInit() {
    this.fetchProducts();
  }

  
  fetchProducts() {
    this.productService.getAllProducts().subscribe(
      (response) => {
        
        this.productList = response.map((product: any) => ({
          ...product,
          supplierId: product.supplier.supplierId, 
        }));
      },
      (error) => {
        console.error('Error fetching products:', error);
      }
    )
    
  }

  // Delete a product
  deleteProduct(productId: number) {
    this.productService.deleteProduct(productId).subscribe(
      () => {
        console.log(`Product with ID ${productId} deleted successfully.`);
        // Refresh product list after deletion
        this.productList = this.productList.filter(product => product.id !== productId);
        this.fetchProducts();
      },
      (error) => {
        console.error(`Error deleting product with ID ${productId}:`, error);
      }
    );
  }

}
