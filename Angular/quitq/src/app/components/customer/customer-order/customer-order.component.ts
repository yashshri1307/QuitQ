import { Component } from '@angular/core';

interface Order {
  id: number;
  status: string;
  date: string;
  total: number;
}

@Component({
  selector: 'app-customer-order',
  templateUrl: './customer-order.component.html',
  styleUrls: ['./customer-order.component.css']
})
export class CustomerOrderComponent {
 
  orders: Order[] = [
    { id: 1, status: 'Shipped', date: '2024-12-10', total: 120.99 },
    { id: 2, status: 'Delivered', date: '2024-12-09', total: 89.49 },
    { id: 3, status: 'Processing', date: '2024-12-05', total: 159.99 },
  ];

  
  viewOrderDetails(orderId: number): void {
    console.log(`Viewing details for Order ID: ${orderId}`);
    
  }
}
