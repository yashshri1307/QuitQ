import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthRequest } from 'src/app/models/AuthRequest';
import { supplier } from 'src/app/models/Supplier';
import { AuthService } from 'src/app/services/auth.service';
import { JwtClientService } from 'src/app/services/jwt-client.service';
import { SupplierService } from 'src/app/services/supplier.service';
@Component({
  selector: 'app-supplier-login',
  templateUrl: './supplier-login.component.html',
  styleUrls: ['./supplier-login.component.css']
})
export class SupplierLoginComponent {

  
  email!:string;
  password!:string;
  errorMessage!:string;
  
  authRequest: AuthRequest = new AuthRequest();
  token!: string;
  
  constructor(private authService: AuthService,private jwtService: JwtClientService, private router: Router) {}


  login(){
    this.authRequest.username = this.email;
    this.authRequest.password = this.password;
  
    this.getAccessToken(this.authRequest);

  }
  
  getAccessToken(authRequest: AuthRequest): void {
    const role = 'supplier';
    this.jwtService.getGeneratedToken(authRequest,role).subscribe(
      (genToken:any) => {
        this.token = genToken;
        console.log('Token received:', this.token);

        
        localStorage.setItem('authToken', this.token);

        this.authService.login(this.email, this.token,role);
        this.router.navigate(['/supplier-dashboard']);
      },
      (error: any) => {
        this.errorMessage="Invalid Email or Password"
        console.error('Authentication failed:', error);
      }
    );

}
}
