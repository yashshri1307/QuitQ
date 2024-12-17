import { Component, OnInit } from '@angular/core';
import { product } from 'src/app/models/Product';
import { AuthService } from 'src/app/services/auth.service';
import { CartService } from 'src/app/services/cart.service';
import { ProductService } from 'src/app/services/product.service';
import { SearchService } from 'src/app/services/search.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{

  logo="assets/logo.png";

  loggedIn: boolean = false;

  getAllProducts: any[] = []; 

  searchQuery: string = '';

  constructor(private authService: AuthService,private productService: ProductService,private cartService: CartService,private searchService:SearchService) {}

  ngOnInit(): void {
    this.fetchAllProducts();
    this.authService.loggedIn$.subscribe(loggedIn => {
      this.loggedIn = loggedIn;
      
      if (this.allProducts.length === 0) {
        this.productService.getAllProducts().subscribe((data) => {
          this.allProducts = data;
          this.filteredProducts = data; 
        });
      } else {
        this.filteredProducts = this.allProducts; 
      }
    });
    this.searchService.searchQuery$.subscribe((query) => {
      this.searchQuery = query;
      this.onSearchProducts();
    });
  }
  

  // Carousel images
  carouselImages: string[] = ['img1.jpg', 'img2.jpg', 'img3.jpg', 'img4.jpg'];
  currentImageIndex: number = 0;

  // Categories
  categories: string[] = ['Fashion','Electronics', 'Mobiles', 'Grocery', 'Home Appliances','Toys'];

  // Products
  allProducts: product[] = [];
  filteredProducts: any[] = [];


   onAddToCart(product: any): void {
    this.cartService.addToCart(product);
    alert("Product added to cart:")
    console.log('Product added to cart:', product);
  }
  // Carousel navigation
  prevImage() {
    this.currentImageIndex =
      (this.currentImageIndex - 1 + this.carouselImages.length) %
      this.carouselImages.length;
  }

  nextImage() {
    this.currentImageIndex =
      (this.currentImageIndex + 1) % this.carouselImages.length;
  }

  // Filter products by category
  filterProducts(category: string) {
    const checkboxes = document.querySelectorAll('input[type="checkbox"]');
    const checkedCategories = Array.from(checkboxes)
      .filter((cb: any) => cb.checked)
      .map((cb: any) => cb.nextSibling.textContent.trim());

    
  }

  // Fetch all products
  fetchAllProducts(): void {
    this.productService.getAllProducts().subscribe(
      (data) => {
        this.getAllProducts = data;
      },
      (error) => {
        console.error('Error fetching products', error);
      }
    );
  }

  onSearchProducts(): void {
    const query = this.searchQuery.trim().toLowerCase();
    if (query) {
      this.filteredProducts = this.allProducts.filter((product) =>
        product.name.toLowerCase().includes(query)
      );
    } else {
      this.filteredProducts = this.allProducts; // Reset to all products
    }
  }
  
  
}


