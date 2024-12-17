import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { OrdersService } from '../../../services/orders.service';

@Component({
  selector: 'app-update-orders',
  templateUrl: './update-orders.component.html',
  styleUrls: ['./update-orders.component.css'],
})
export class UpdateOrdersComponent {
  updateOrderForm: FormGroup;

  constructor(private fb: FormBuilder, private ordersService: OrdersService) {
    this.updateOrderForm = this.fb.group({
      orderId: ['', [Validators.required]],
      customerId: ['', [Validators.required]],
      orderDate: ['', [Validators.required]],
      status: ['', [Validators.required]],
      totalAmount: ['', [Validators.required, Validators.min(1)]],
    });
  }

  updateOrder() {
    if (this.updateOrderForm.valid) {
      this.ordersService.addOrder(this.updateOrderForm.value).subscribe({
        next: (response) => {
          alert('Order updated successfully!');
        },
        error: (err) => {
          console.error('Error updating order:', err);
          alert('Failed to update order.');
        },
      });
    } else {
      alert('Please fill out all required fields.');
    }
  }
}
