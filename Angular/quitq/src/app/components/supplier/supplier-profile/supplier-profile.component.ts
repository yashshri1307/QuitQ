import { Component, OnInit } from '@angular/core';
import { supplier } from 'src/app/models/Supplier';
import { AuthService } from 'src/app/services/auth.service';
import { SupplierService } from 'src/app/services/supplier.service';
@Component({
  selector: 'app-supplier-profile',
  templateUrl: './supplier-profile.component.html',
  styleUrls: ['./supplier-profile.component.css']
})
export class SupplierProfileComponent implements OnInit{

   male="assets/male.png";
    female="assets/female.png";
  
    supplier!: supplier; 
    selectedSection: string = 'profile'; 
    selectedSubSection: string = 'basic';
    loggedInEmail: string = '';
  
    constructor(private supplierservice: SupplierService,private authService: AuthService) {}
  
    ngOnInit(): void {
      
      this.loggedInEmail = this.authService.getLoggedInEmail(); 
      this.fetchSupplierDetails(this.loggedInEmail);
  
    }
  
    fetchSupplierDetails(email: string): void {
      this.supplierservice.getSupplierByEmail(email).subscribe({
        next: (data) => {
          this.supplier = data;
          console.log('Customer details fetched:', data);
        },
        error: (err) => {
          console.error('Error fetching customer details:', err);
        }
      });
    }
  
    // Toggle between "My Profile" and "My Favorites"
    selectSection(section: string): void {
      this.selectedSection = section;
    }
  
    selectSubSection(subSection: string): void {
      this.selectedSubSection = subSection;
    }
}
