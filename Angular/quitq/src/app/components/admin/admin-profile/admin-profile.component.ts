import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-admin-profile',
  templateUrl: './admin-profile.component.html',
  styleUrls: ['./admin-profile.component.css']
})
export class AdminProfileComponent {
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
}
