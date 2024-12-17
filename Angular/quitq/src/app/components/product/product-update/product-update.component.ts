import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {
  product: any = {};
  updatedProduct: any = {};
  productId: number | null = null; 
  errorMessage: string = ''; 

  editMode = {
    name: false,
    description: false,
    price: false,
  };

  constructor(private productService: ProductService) {}

  ngOnInit(): void {
    
  }

  
  fetchProductById(): void {
    if (this.productId) {
      this.productService.getProductById(this.productId).subscribe(
        (response) => {
          this.product = response; 
          this.updatedProduct = { ...this.product }; 
          this.errorMessage = '';
        },
        (error) => {
          this.errorMessage = 'Product not found or error fetching product.';
          console.error(error);
        }
      );
    } else {
      this.errorMessage = 'Please enter a valid product ID.';
    }
  }

  
  toggleEdit(field: keyof typeof this.editMode): void {
    this.editMode[field] = !this.editMode[field];
  }

  submit(): void {
    const updatedObject = { ...this.product, ...this.updatedProduct };
    console.log('Updated Product Object:', updatedObject);

    this.productService.updateProduct(this.productId!,updatedObject).subscribe(
      (response) => {
        console.log('Product updated successfully:', response);
        alert("Product updated successfully");
        this.errorMessage = '';
      },
      (error) => {
        this.errorMessage = 'Error updating product.';
        console.error('Error:', error);
      }
    );
  }
}
