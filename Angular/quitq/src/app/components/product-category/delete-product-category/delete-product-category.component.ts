import { Component } from '@angular/core';
import { ProductCategoryService } from '../../../services/product-category.service';

@Component({
  selector: 'app-delete-product-category',
  templateUrl: './delete-product-category.component.html',
})
export class DeleteProductCategoryComponent {
  categoryId = 0;

  constructor(private service: ProductCategoryService) {}

  onDelete() {
    this.service.deleteProductCategoryById(this.categoryId).subscribe({
      next: (res) => {
        console.log('Success response:', res); // Log success response
        alert('Product Category Deleted Successfully!');
      },
      error: (err) => {
        console.error('Error response:', err); // Log error details for debugging
        const errorMessage =
          err.error?.message || 'Error deleting product category!';
        alert(errorMessage);
      },
    });
  }
  
  // onDelete() {
  //   this.service.deleteProductCategoryById(this.categoryId).subscribe({
  //     next: (res) => alert('Product Category Deleted Successfully!'),
  //     error: (err) => alert('Error deleting product category!'),
  //   });
  // }
}
