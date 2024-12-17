import { Component, OnInit } from '@angular/core';
import { OrdersService } from '../../../services/orders.service';

@Component({
  selector: 'app-display-orders',
  templateUrl: './display-orders.component.html',
  styleUrls: ['./display-orders.component.css'],
})
export class DisplayOrdersComponent implements OnInit {
  orders: any[] = [];

  constructor(private ordersService: OrdersService) {}

  ngOnInit(): void {
    this.fetchOrders();
  }

  fetchOrders() {
    this.ordersService.getAllOrders().subscribe({
      next: (data) => {
        this.orders = data;
      },
      error: (err) => {
        console.error('Error fetching orders:', err);
        alert('Failed to fetch orders.');
      },
    });
  }
}
