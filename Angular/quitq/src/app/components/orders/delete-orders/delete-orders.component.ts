import { Component } from '@angular/core';
import { OrdersService } from '../../../services/orders.service';

@Component({
  selector: 'app-delete-orders',
  templateUrl: './delete-orders.component.html',
  styleUrls: ['./delete-orders.component.css'],
})
export class DeleteOrdersComponent {
  orderId: number | undefined;

  constructor(private ordersService: OrdersService) {}

  deleteOrder() {
    if (this.orderId) {
      this.ordersService.deleteOrderById(this.orderId).subscribe({
        next: (response) => {
          alert('Order deleted successfully!');
          this.orderId = undefined;
        },
        error: (err) => {
          console.error('Error deleting order:', err);
          alert('Failed to delete order.');
        },
      });
    } else {
      alert('Please provide a valid Order ID.');
    }
  }
}
