import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { JwtClientService } from 'src/app/services/jwt-client.service';

@Component({
  selector: 'app-security',
  templateUrl: './security.component.html',
  styleUrls: ['./security.component.css']
})
export class SecurityComponent implements OnInit{
  token!: string;
  response: any;
  role!: string;

  constructor(private jwtService: JwtClientService,private authService: AuthService,private router:Router) {console.log('SecurityComponent initialized');}

  ngOnInit(): void {
    this.token = localStorage.getItem('authToken') || '';
    console.log('Token from LocalStorage:', this.token);
    this.role = localStorage.getItem('role') || '';
    if (this.token) {
      this.accessApi(this.token);
      this.authService.login('username', this.token,this.role);  
    }
  }

  public accessApi(token: string): void {
    this.jwtService.authorizeRequest(token,'customer/getcustomerByEmail/{yash13@gmail.com}').subscribe(
      (responseData: any) => {
        this.response = responseData;
        console.log('API Response:', responseData);
      },
      (error: any) => {
        console.error('API Access Error:', error);
      }
    );
  }
  isLoggedIn(): boolean {
    return localStorage.getItem('authToken') !== null;
  }

  logout(): void {
    localStorage.removeItem('authToken');
    localStorage.removeItem('role'); 
    this.token = '';
    this.authService.logout();
    console.log('Logged out successfully.');
  }

  
}
