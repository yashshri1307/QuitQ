import { Component } from '@angular/core';
import { ProductCategoryService } from '../../../services/product-category.service';

@Component({
  selector: 'app-update-product-category',
  templateUrl: './update-product-category.component.html',
  styleUrls: ['./update-product-category.component.css'],
})
export class UpdateProductCategoryComponent {
  productCategory = {
    categoryId: 0,
    name: '',
    description: '',
  };

  isFormSubmitted = false;

  constructor(private service: ProductCategoryService) {}

  onSubmit() {
    this.isFormSubmitted = true;

    if (!this.productCategory.categoryId || !this.productCategory.name || !this.productCategory.description) {
      alert('Please fill in all required fields.');
      return;
    }

    this.service.updateProductCategory(this.productCategory).subscribe({
      next: () => {
        alert('Product Category Updated Successfully!');
        this.resetForm();
      },
      error: (err) => {
        console.error(err);
        alert('Error updating product category!');
      },
    });
  }

  private resetForm() {
    this.productCategory = {
      categoryId: 0,
      name: '',
      description: '',
    };
    this.isFormSubmitted = false;
  }
}



// import { Component } from '@angular/core';
// import { ProductCategoryService } from '../../../services/product-category.service';

// @Component({
//   selector: 'app-update-product-category',
//   templateUrl: './update-product-category.component.html',
// })
// export class UpdateProductCategoryComponent {
//   productCategory = {
//     categoryId: 0,
//     name: '',
//     description: '',
//   };

//   constructor(private service: ProductCategoryService) {}

//   onSubmit() {
//     this.service.updateProductCategory(this.productCategory).subscribe({
//       next: (res) => alert('Product Category Updated Successfully!'),
//       error: (err) => alert('Error updating product category!'),
//     });
//   }
// }
