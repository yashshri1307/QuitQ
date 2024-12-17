import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { product } from 'src/app/models/Product';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private cartItems: product[] = [];
  private cartSubject: BehaviorSubject<product[]> = new BehaviorSubject<product[]>([]);

  constructor() {
    // Load cart items from localStorage
    const storedCart = localStorage.getItem('cartItems');
    if (storedCart) {
      this.cartItems = JSON.parse(storedCart);
      this.cartSubject.next(this.cartItems);
    }
  }

  getCartItems(): Observable<product[]> {
    return this.cartSubject.asObservable();
  }

  // Add product to cart
  addToCart(item: product): void {
    const existingItem = this.cartItems.find(i => i.productId === item.productId);
    if (existingItem) {
      
      existingItem.quantity += 1;
    } else {
      
      this.cartItems.push({ ...item, quantity: 1 });
    }
    this.updateCart();
  }

  
  removeFromCart(item: product): void {
    this.cartItems = this.cartItems.filter(i => i.productId !== item.productId);
    this.updateCart();
  }

  
  increaseQuantity(item: product): void {
    const index = this.cartItems.findIndex(i => i.productId === item.productId);
    if (index !== -1) {
      this.cartItems[index].quantity += 1;
    }
    this.updateCart();
  }

  
  decreaseQuantity(item: product): void {
    const index = this.cartItems.findIndex(i => i.productId === item.productId);
    if (index !== -1 && this.cartItems[index].quantity > 1) {
      this.cartItems[index].quantity -= 1;
    }
    this.updateCart();
  }

  //  total price
  calculateTotal(): number {
    return this.cartItems.reduce((sum, item) => {
      const price = item.price || 0;       
      const quantity = item.quantity || 1; 
      return sum + price * quantity;
    }, 0);
  }

  
  private updateCart(): void {
    localStorage.setItem('cartItems', JSON.stringify(this.cartItems));
    this.cartSubject.next([...this.cartItems]);
  }
}
