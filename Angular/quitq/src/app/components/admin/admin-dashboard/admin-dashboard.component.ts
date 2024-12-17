// import { Component } from '@angular/core';

// @Component({
//   selector: 'app-admin-dashboard',
//   templateUrl: './admin-dashboard.component.html',
//   styleUrls: ['./admin-dashboard.component.css']
// })
// export class AdminDashboardComponent {

// }


import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent {
  constructor(private router: Router, private authService: AuthService) {}

  viewUsers(): void {
    // Navigate to the Users management page
    this.router.navigate(['/admin-users']);
  }

  manageSettings(): void {
    // Navigate to the Settings management page
    this.router.navigate(['/admin-settings']);
  }

  logout(): void {
    // Clear token and logout
    localStorage.removeItem('authToken');
    this.authService.logout();
    this.router.navigate(['/admin-login']);
  }
}


