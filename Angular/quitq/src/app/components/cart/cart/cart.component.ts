import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/app/services/cart.service';
import { product } from 'src/app/models/Product';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { Orders } from 'src/app/models/orders';
import { OrdersService } from 'src/app/services/orders.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  cartItems: product[] = [];
  total: number = 0;
  loggedIn: boolean = false;
  
  order: Orders = {
    orderId: 0,           // You can set a default value or leave it to be auto-generated
    customerId: 0,
    orderDate: new Date(),
    status: '',
    totalAmount: 0
  };

  constructor(private cartService: CartService,private router:Router,private authService:AuthService,private orderService:OrdersService) {}

  ngOnInit(): void {
    this.authService.loggedIn$.subscribe(loggedIn => {
      this.loggedIn = loggedIn;});
    this.cartService.getCartItems().subscribe((items: product[]) => {
      this.cartItems = items;
      this.total = this.cartService.calculateTotal();
    });
  }

  addToCart(product: product): void {
    this.cartService.addToCart(product);
  }

  removeFromCart(product: product): void {
    this.cartService.removeFromCart(product);
  }

  increaseQuantity(product: product): void {
    this.cartService.increaseQuantity(product);
  }

  decreaseQuantity(product: product): void {
    this.cartService.decreaseQuantity(product);
  }

  calculateTotal(): number {
    return this.cartService.calculateTotal();
  }

  onProceedToCheckout() {
    if (!this.loggedIn) {
      // User not logged in: redirect to login page
      this.router.navigate(['/customer-login']);
    } else {
  
      // this.order.customerId=19;
      // this.order.status="PENDING";
      // this.order.totalAmount=this.total;
      // // Proceed with checkout process
      // this.orderService.addOrder(this.order);
      // console.log('yes did');
      // You can add checkout logic here
      this.router.navigate(['/payment']);
    }
  }
}
