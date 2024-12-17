import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Inventory } from 'src/app/models/Inventory';
import { InventoryService } from 'src/app/services/inventory.service';

@Component({
  selector: 'app-add-inventory',
  templateUrl: './add-inventory.component.html',
})
export class AddInventoryComponent {
  inventoryForm!: FormGroup;

  constructor(private fb: FormBuilder, private inventoryService: InventoryService) {
    this.inventoryForm = this.fb.group({
      productId: [null, [Validators.required, Validators.min(1)]],
      stockQuantity: [null, [Validators.required, Validators.min(1)]],
      stockValue: [null, [Validators.required, Validators.min(1)]],
      status: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
    });
  }

  addInventory() {
    if (this.inventoryForm.valid) {
      const inventoryData: Inventory = this.inventoryForm.value; // Type-check to match the Inventory model
      console.log('Submitting Inventory:', inventoryData); // Debug log

      this.inventoryService.addInventory(inventoryData).subscribe(
        (response) => {
          alert('Inventory added successfully!');
          console.log('Response:', response); // Debug log
          this.inventoryForm.reset(); // Reset form after successful submission
        },
        (error) => {
          console.error('Failed to add inventory:', error); // Log error
          alert('Failed to add inventory: ' + (error.message || 'Unknown error'));
        }
      );
    } else {
      alert('Form is invalid. Please check the fields.');
    }
  }
}
