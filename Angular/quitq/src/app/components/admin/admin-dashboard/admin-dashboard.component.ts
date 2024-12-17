import { Component } from '@angular/core'; 
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { Admin } from 'src/app/models/Admin';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent {
  male="assets/male.png";
  female="assets/female.png";
  admin={
    name:'',email:""}
  loggedInEmail: string = '';
  constructor(private adminservice: AdminService,private router: Router, private authService: AuthService) {}

  ngOnInit(){
    this.loggedInEmail = this.authService.getLoggedInEmail();
    this.getadmindetails(this.loggedInEmail);
  }
  getadmindetails(email:string):void{
    this.adminservice.getAdminByEmail(email).subscribe({
      next: (data) => {
        this.admin = data;
      },
      error: (err) => {
        console.error('Error fetching Admin details:', err);
      }
    });  }

  viewUsers(): void {
    // Navigate to the Users management page
    this.router.navigate(['/admin-displayall']);
  }

  logout(): void {
    // Clear token and logout
    localStorage.removeItem('authToken');
    this.authService.logout();
    this.router.navigate(['/admin-login']);
  }

  manageProductCategories(): void {
    // Navigate to the Product Categories dashboard
    this.router.navigate(['/product-category-dashboard']);
  }
}


