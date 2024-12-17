import { Component, OnInit } from '@angular/core';
import { InventoryService } from 'src/app/services/inventory.service';

@Component({
  selector: 'app-display-inventory',
  templateUrl: './display-inventory.component.html',
})
export class DisplayInventoryComponent implements OnInit {
  inventories: any[] = [];

  constructor(private inventoryService: InventoryService) {}

  ngOnInit(): void {
    this.loadInventories();
  }

  loadInventories() {
    this.inventoryService.getAllInventories().subscribe(
      (data) => {
        this.inventories = data;
      },
      (error) => {
        alert('Failed to load inventories: ' + error.message);
      }
    );
  }
}
