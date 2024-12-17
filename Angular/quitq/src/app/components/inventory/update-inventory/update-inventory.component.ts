


















import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { InventoryService } from 'src/app/services/inventory.service';
import { Inventory } from 'src/app/models/Inventory';

@Component({
  selector: 'app-update-inventory',
  templateUrl: './update-inventory.component.html',
})
export class UpdateInventoryComponent implements OnInit {
  inventoryForm: FormGroup;
  inventoryId!: number; // Non-null assertion operator

  constructor(
    private fb: FormBuilder,
    private inventoryService: InventoryService,
    private route: ActivatedRoute
  ) {
    this.inventoryForm = this.fb.group({
      inventoryId: [null], // Include inventoryId in the form
      productId: [null, [Validators.required, Validators.min(1)]],
      stockQuantity: [null, [Validators.required, Validators.min(1)]],
      stockValue: [null, [Validators.required, Validators.min(1)]],
      status: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
    });
  }

  ngOnInit(): void {
    // Fetch the inventory ID from the route parameters
    this.inventoryId = +this.route.snapshot.paramMap.get('id')!;
  
    // Fetch the inventory details to prefill the form
    this.inventoryService.getAllInventories().subscribe((inventories: Inventory[]) => {
      const inventory = inventories.find((inv) => inv.inventoryId === this.inventoryId);
      if (inventory) {
        this.inventoryForm.patchValue({
          inventoryId: inventory.inventoryId, // Include inventoryId explicitly
          productId: inventory.productId,
          stockQuantity: inventory.stockQuantity,
          stockValue: inventory.stockValue,
          status: inventory.status,
        });
      }
    });
  }


  updateInventory() {
    if (this.inventoryForm.valid) {
      const updatedInventory: Inventory = {
        ...this.inventoryForm.value, 
        inventoryId: this.inventoryId  // Explicitly include inventoryId
      };
  
      this.inventoryService.updateInventory(updatedInventory).subscribe(
        () => {
          alert('Inventory updated successfully!');
        },
        (error) => {
          console.error('Error updating inventory:', error);
          alert('Failed to update inventory: ' + error.message);
        }
      );
    }
  }
  
  
//   updateInventory() {
//   if (this.inventoryForm.valid) {
//     const updatedInventory: Inventory = {
//       ...this.inventoryForm.value, 
//       inventoryId: this.inventoryId  // Explicitly include inventoryId
//     };

//     this.inventoryService.updateInventory(updatedInventory).subscribe(
//       () => {
//         alert('Inventory updated successfully!');
//       },
//       (error) => {
//         console.error('Error updating inventory:', error);
//         alert('Failed to update inventory: ' + error.message);
//       }
//     );
//   }
// }

  
    }
   