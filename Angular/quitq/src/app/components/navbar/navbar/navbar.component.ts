import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { SearchService } from 'src/app/services/search.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit{
 
  logo="assets/logo.png";

  loggedIn: boolean = false;
  username: string = '';
  role: string = '';
  searchQuery: string = '';

  constructor(private authService: AuthService,private router:Router,private searchService:SearchService) {}

  ngOnInit(): void {
    this.authService.loggedIn$.subscribe((loggedIn) => {
      this.loggedIn = loggedIn;
      if (loggedIn) {
        this.authService.username$.subscribe((username) => {
          this.username = username;
        });
        this.role = this.authService.getRole();
      }
    });
  }

  logout(): void {
    this.authService.logout();  
  }


  viewProfile(): void {

    console.log("role=")
    console.log(this.role);
    if (this.role === 'supplier') {
      console.log("in navbar ")
      this.router.navigate(['/supplier-profile']);
    } 
    if (this.role === 'customer'){
      this.router.navigate(['/customer-profile']);
    }
    if (this.role === 'admin'){
      this.router.navigate(['/admin-profile']);
    }
  }

  myOrders(): void {

    console.log(this.role);
    if (this.role === 'supplier') {

      this.router.navigate(['/supplier-dashboard']);
    } 
    if (this.role === 'customer') {
      this.router.navigate(['/customer-order']);
    }
    if (this.role === 'admin') {
      this.router.navigate(['/admin-dashboard']);
    }
  }

  myoption(): void {
    console.log(this.role);
    if (this.role === 'supplier') {
      console.log("in navbar ")
      this.router.navigate(['/orders-dashboard']);
    } 
  }

  onSearchProducts(){
  // Emit the search query to the search service
      this.searchService.sendSearchQuery(this.searchQuery);
  
  }
  
}
