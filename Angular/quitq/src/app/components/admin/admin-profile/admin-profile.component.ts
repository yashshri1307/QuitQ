import { Component } from '@angular/core';

@Component({
  selector: 'app-admin-profile',
  templateUrl: './admin-profile.component.html',
  styleUrls: ['./admin-profile.component.css']
})
export class AdminProfileComponent {

}




// import { Component, OnInit } from '@angular/core';
// import { Router } from '@angular/router';
// import { AuthService } from 'src/app/services/auth.service';

// @Component({
//   selector: 'app-admin-profile',
//   templateUrl: './admin-profile.component.html',
//   styleUrls: ['./admin-profile.component.css']
// })
// export class AdminProfileComponent implements OnInit {
//   adminName: string = 'John Doe'; // Replace with real data from API
//   adminEmail: string = 'admin@example.com'; // Replace with real data from API

//   constructor(private router: Router, private authService: AuthService) {}

//   ngOnInit(): void {
//     // You can fetch admin data here using a service
//     const token = localStorage.getItem('authToken');
//     if (!token) {
//       alert('You are not logged in!');
//       this.router.navigate(['/admin-login']);
//     }
//   }

//   viewUsers(): void {
//     this.router.navigate(['/admin-users']);
//   }

//   manageSettings(): void {
//     this.router.navigate(['/admin-settings']);
//   }

//   logout(): void {
//     localStorage.removeItem('authToken');
//     this.authService.logout();
//     this.router.navigate(['/admin-login']);
//   }
// }
