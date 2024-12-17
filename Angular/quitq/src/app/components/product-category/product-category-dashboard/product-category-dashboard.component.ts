import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-category-dashboard',
  templateUrl: './product-category-dashboard.component.html',
  styleUrls: ['./product-category-dashboard.component.css']
})
export class ProductCategoryDashboardComponent {
  cards = [
    {
      title: 'Add Product Category',
      description: 'Add a new product category to the system.',
      link: '/add-product-category'
    },
    {
      title: 'Update Product Category',
      description: 'Update an existing product category.',
      link: '/update-product-category'
    },
    {
      title: 'Delete Product Category',
      description: 'Delete a product category from the system.',
      link: '/delete-product-category'
    },
    {
      title: 'Display Product Categories',
      description: 'View all product categories in the system.',
      link: '/display-product-category'
    }
  ];

  constructor(private router: Router) {}

  navigate(link: string): void {
    this.router.navigate([link]); // Navigate to the desired route
  }
}

// import { Component } from '@angular/core';

// @Component({
//   selector: 'app-product-category-dashboard',
//   templateUrl: './product-category-dashboard.component.html',
//   styleUrls: ['./product-category-dashboard.component.css']
// })
// export class ProductCategoryDashboardComponent {
//   cards = [
//     {
//       title: 'Add Product Category',
//       description: 'Add a new product category to the system.',
//       link: '/add-product-category'
//     },
//     {
//       title: 'Update Product Category',
//       description: 'Update an existing product category.',
//       link: '/update-product-category'
//     },
//     {
//       title: 'Delete Product Category',
//       description: 'Delete a product category from the system.',
//       link: '/delete-product-category'
//     },
//     {
//       title: 'Display Product Categories',
//       description: 'View all product categories in the system.',
//       link: '/display-product-category'
//     }
//   ];
// }


// latest change 16-12-2024 

// import { Component } from '@angular/core';

// @Component({
//   selector: 'app-product-category-dashboard',
//   templateUrl: './product-category-dashboard.component.html',
//   styleUrls: ['./product-category-dashboard.component.css']
// })
// export class ProductCategoryDashboardComponent {

//   cards = [
//     {
//       title: 'Add Product Category',
//       description: 'Add a new product category to the system.',
//       link: '/add-product-category'
//     },
//     {
//       title: 'Update Product Category',
//       description: 'Update an existing product category.',
//       link: '/update-product-category'
//     },
//     {
//       title: 'Delete Product Category',
//       description: 'Delete a product category from the system.',
//       link: '/delete-product-category'
//     },
//     {
//       title: 'Display Product Categories',
//       description: 'View all product categories in the system.',
//       link: '/display-product-category'
//     }
//   ];
// }



// import { Component } from '@angular/core';

// @Component({
//   selector: 'app-product-category-dashboard',
//   templateUrl: './product-category-dashboard.component.html',
//   styleUrls: ['./product-category-dashboard.component.css']
// })
// export class ProductCategoryDashboardComponent {

//   cards = [
//     {
//       title: 'Add Product Category',
//       description: 'Add a new product category to the system.',
//       link: '/add-product-category'
//     },
//     {
//       title: 'Update Product Category',
//       description: 'Update an existing product category.',
//       link: '/update-product-category'
//     },
//     {
//       title: 'Delete Product Category',
//       description: 'Delete a product category from the system.',
//       link: '/delete-product-category'
//     },
//     {
//       title: 'Display Product Categories',
//       description: 'View all product categories in the system.',
//       link: '/display-product-category'
//     }
//   ];
// }
