
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { InventoryService } from 'src/app/services/inventory.service';

@Component({
  selector: 'app-delete-inventory',
  template: `
    <div class="container mt-5 text-center">
      <h3 class="text-danger">Delete Inventory</h3>
      <p>Enter the Inventory ID you wish to delete:</p>
      <input
        type="number"
        class="form-control w-25 mx-auto mb-3"
        [(ngModel)]="inventoryId"
        placeholder="Enter Inventory ID"
      />
      <button class="btn btn-danger mx-2" (click)="deleteInventory()">Yes, Delete</button>
      <button class="btn btn-secondary mx-2" (click)="cancel()">No, Cancel</button>
    </div>
  `,
})
export class DeleteInventoryComponent {
  inventoryId: number | null = null;

  constructor(
    private inventoryService: InventoryService,
    private router: Router
  ) {}

  deleteInventory() {
    if (!this.inventoryId) {
      alert('Please enter a valid Inventory ID.');
      return;
    }

    this.inventoryService.deleteInventory(this.inventoryId).subscribe({
      next: () => {
        alert('Inventory deleted successfully!');
        this.router.navigate(['/inventory/display']);
      },
      error: (error) => {
        alert('Failed to delete inventory: ' + error.message);
      },
    });
  }

  cancel() {
    this.router.navigate(['/inventory/display']);
  }
}



// import { Component } from '@angular/core';
// import { ActivatedRoute, Router } from '@angular/router';
// import { InventoryService } from 'src/app/services/inventory.service';

// @Component({
//   selector: 'app-delete-inventory',
//   template: `
//     <div class="container mt-5 text-center">
//       <h3>Are you sure you want to delete this inventory item?</h3>
//       <button class="btn btn-danger mx-2" (click)="deleteInventory()">Yes</button>
//       <button class="btn btn-secondary mx-2" (click)="cancel()">No</button>
//     </div>
//   `,
// })
// export class DeleteInventoryComponent {
//   inventoryId: number;

//   constructor(
//     private inventoryService: InventoryService,
//     private route: ActivatedRoute,
//     private router: Router
//   ) {
//     this.inventoryId = +this.route.snapshot.paramMap.get('id')!;
//   }

//   deleteInventory() {
//     this.inventoryService.deleteInventory(this.inventoryId).subscribe({
//       next: (response) => {
//         alert('Inventory deleted successfully!');
//         this.router.navigate(['/inventory/display']);
//       },
//       error: (error) => {
//         alert('Failed to delete inventory: ' + error.message);
//       }
//     });
//   }

//   cancel() {
//     this.router.navigate(['/inventory/display']);
//   }
// }
