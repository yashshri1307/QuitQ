import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';
import { AuthService } from 'src/app/services/auth.service'; // Assuming you have an AuthService to get the logged-in email

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
  isAuthorized: boolean = false; // Track if the user is authorized to view/edit the product

  editMode = {
    name: false,
    description: false,
    price: false,
  };

  constructor(private productService: ProductService, private authService: AuthService) {}

  ngOnInit(): void {}

  fetchProductById(): void {
    if (this.productId) {
      this.productService.getProductById(this.productId).subscribe(
        (response) => {
          this.product = response;
          const loggedInEmail = this.authService.getLoggedInEmail(); // Get logged-in supplier's email

          // Check if the logged-in supplier's email matches the product's supplier email
          if (this.product.supplier.email === loggedInEmail) {
            this.isAuthorized = true; // User is authorized
            this.updatedProduct = { ...this.product };
            this.errorMessage = ''; // Clear any previous error message
          } else {
            this.isAuthorized = false; // Unauthorized
            this.errorMessage = 'You are not authorized to view or edit this product.';
          }
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

    // Only attempt to submit if the user is authorized
    if (this.isAuthorized) {
      this.productService.updateProduct(this.productId!, updatedObject).subscribe(
        (response) => {
          alert("Product updated successfully");
          this.errorMessage = ''; // Clear error message on success
        },
        (error) => {
          this.errorMessage = 'Error updating product.';
          console.error('Error:', error);
        }
      );
    } else {
      this.errorMessage = 'You are not authorized to update this product.';
    }
  }
}
