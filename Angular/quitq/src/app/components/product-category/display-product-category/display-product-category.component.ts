import { Component, OnInit } from '@angular/core';
import { ProductCategoryService } from '../../../services/product-category.service';

@Component({
  selector: 'app-display-product-category',
  templateUrl: './display-product-category.component.html',
})
export class DisplayProductCategoryComponent implements OnInit {
  categories: any[] = [];

  constructor(private service: ProductCategoryService) {}

  ngOnInit(): void {
    console.log('Fetching product categories...');
    this.service.getAllProductCategories().subscribe({
      next: (data) => {
        console.log('Product categories fetched:', data);
        this.categories = data;
      },
      error: (err) => {
        console.error('Error fetching categories:', err);
        alert('Error fetching categories!'); // Notify the user
      },
    });
  }
  
}
