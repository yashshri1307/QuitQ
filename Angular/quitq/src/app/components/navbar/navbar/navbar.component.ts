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
        console.log('User logged in in nav:', loggedIn);
        console.log("after login redirected i am here");
        this.authService.username$.subscribe((username) => {
          this.username = username;
          console.log('Username3:', this.username);
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
    } else {
      this.router.navigate(['/customer-profile']);
    }
  }

  myOrders(): void {

    console.log("role=")
    console.log(this.role);
    if (this.role === 'supplier') {
      console.log("in navbar ")
      this.router.navigate(['/supplier-dashboard']);
    } else {
      this.router.navigate(['/customer-order']);
    }
  }

  onSearchProducts(){
  // Emit the search query to the search service
      this.searchService.sendSearchQuery(this.searchQuery);
  
  }
  
}
