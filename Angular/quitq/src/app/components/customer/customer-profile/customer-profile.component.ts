import { Component, OnInit } from '@angular/core';
import { customer } from 'src/app/models/Customer';
import { AuthService } from 'src/app/services/auth.service';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-customer-profile',
  templateUrl: './customer-profile.component.html',
  styleUrls: ['./customer-profile.component.css']
})
export class CustomerProfileComponent implements OnInit{

  male="assets/male.png";
  female="assets/female.png";

  customer!: customer; 
  selectedSection: string = 'profile'; 
  selectedSubSection: string = 'basic';
  loggedInEmail: string = '';

  constructor(private customerService: CustomerService,private authService: AuthService) {}

  ngOnInit(): void {
    
    this.loggedInEmail = this.authService.getLoggedInEmail();
   console.log("email which is token="+this.loggedInEmail)
    this.fetchCustomerDetails(this.loggedInEmail);


  }

  fetchCustomerDetails(email: string): void {
    console.log("ayamein")
    this.customerService.getCustomerByEmail(email).subscribe({
      next: (data) => {
        this.customer = data;
        console.log('Customer details fetched:', data);
      },
      error: (err) => {
        console.error('Error fetching customer details:', err);
      }
    });
  }

  
  selectSection(section: string): void {
    this.selectedSection = section;
  }

  selectSubSection(subSection: string): void {
    this.selectedSubSection = subSection;
  }
}



