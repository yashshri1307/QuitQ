import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { OrdersService } from '../../../services/orders.service';

@Component({
  selector: 'app-add-orders',
  templateUrl: './add-orders.component.html',
  styleUrls: ['./add-orders.component.css'],
})
export class AddOrdersComponent {
  orderForm: FormGroup;

  constructor(private fb: FormBuilder, private ordersService: OrdersService) {
    this.orderForm = this.fb.group({
      customerId: ['', [Validators.required]],
      orderDate: ['', [Validators.required]],
      status: ['', [Validators.required]],
      totalAmount: ['', [Validators.required, Validators.min(1)]],
    });
  }

  addOrder() {
    if (this.orderForm.valid) {
      this.ordersService.addOrder(this.orderForm.value).subscribe({
        next: (response) => {
          alert('Order added successfully!');
        },
        error: (err) => {
          console.error('Error adding order:', err);
          alert('Failed to add order.');
        },
      });
    } else {
      alert('Please fill out all required fields.');
    }
  }
}
