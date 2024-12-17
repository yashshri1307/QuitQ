import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthRequest } from 'src/app/models/AuthRequest';
import { customer } from 'src/app/models/Customer';
import { AuthService } from 'src/app/services/auth.service';
import { CustomerService } from 'src/app/services/customer.service';
import { JwtClientService } from 'src/app/services/jwt-client.service';

@Component({
  selector: 'app-customer-login',
  templateUrl: './customer-login.component.html',
  styleUrls: ['./customer-login.component.css']
})
export class CustomerLoginComponent {

  email!:string;
  password!:string;
  errorMessage!:string;

  authRequest: AuthRequest = new AuthRequest();
  token!: string;

  constructor(private authService: AuthService,private jwtService: JwtClientService, private router: Router) {}

  
  login(): void{
    this.authRequest.username = this.email;
    this.authRequest.password = this.password;
  
    this.getAccessToken(this.authRequest);
  }

  
  getAccessToken(authRequest: AuthRequest): void {
    const role = 'customer';
    this.jwtService.getGeneratedToken(authRequest,role).subscribe(
      (genToken:any) => {
        this.token = genToken;
        console.log('Token received:', this.token);

        
        localStorage.setItem('authToken', this.token);

        this.authService.login(this.email, this.token,role);
        this.router.navigate(['/home']);
      },
      (error: any) => {
        this.errorMessage="Invalid Email or Password"
        console.error('Authentication failed:', error);
      }
    );
  }
  
  
  

}
