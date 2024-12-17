
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ProductCategoryService } from '../../../services/product-category.service';

@Component({
  selector: 'app-add-product-category',
  templateUrl: './add-product-category.component.html',
  styleUrls: ['./add-product-category.component.css'],
})
export class AddProductCategoryComponent {
  productCategoryForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private productCategoryService: ProductCategoryService
  ) {
    this.productCategoryForm = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(3)]],
      description: ['', [Validators.required, Validators.minLength(5)]],
    });
  }

  addProductCategory() {
    if (this.productCategoryForm.valid) {
      this.productCategoryService
        .addProductCategory(this.productCategoryForm.value)
        .subscribe({
          next: (response) => {
            alert('Product Category added successfully!');
            this.productCategoryForm.reset();
          },
          error: (err) => {
            console.error('Error adding product category:', err);
            alert(err.message || 'Failed to add product category.');
          },
        });
    } else {
      alert('Please fill out all required fields.');
    }
  }
}



// import { Component } from '@angular/core';
// import { ProductCategoryService } from '../../../services/product-category.service';
// import { ProductCategory } from 'src/app/models/ProductCategory';

// @Component({
//   selector: 'app-add-product-category',
//   templateUrl: './add-product-category.component.html',
// })
// export class AddProductCategoryComponent {
//   productCategory: ProductCategory = {
//     name: '', // Default value for name
//     description: '' // Default value for description
//   };

//   constructor(private productCategoryService:ProductCategoryService) {}

//   addCategory(): void {
//     this.productCategoryService.addProductCategory(this.productCategory);
//     console.log('Category added:', this.productCategory);
//     // Add logic to send this.productCategory to the backend
//   }
// }
