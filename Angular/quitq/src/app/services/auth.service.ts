import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { JwtClientService } from './jwt-client.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loggedInSubject = new BehaviorSubject<boolean>(false);
  private usernameSubject = new BehaviorSubject<string>('');
  private roleSubject = new BehaviorSubject<string>('');

  constructor(private jwtService: JwtClientService) {
    const token = localStorage.getItem('authToken');
    const username = localStorage.getItem('username');
    const role = localStorage.getItem('role');

    if (token && username && role) {
      // If token exists
      this.loggedInSubject.next(true);
      this.usernameSubject.next(username);  
      this.roleSubject.next(role);
      
      
      this.fetchUsernameFromBackend(token); 
    }
  }

  get loggedIn$() {
    return this.loggedInSubject.asObservable();
  }

  get username$() {
    return this.usernameSubject.asObservable();
  }

  get role$() {
    return this.roleSubject.asObservable();
  }

  login(username: string, token: string, role: string): void {
    // Save login details in localStorage
    localStorage.setItem('authToken', token);
    localStorage.setItem('username', username);
    localStorage.setItem('role', role); 

    // Set the login state
    this.loggedInSubject.next(true);
    this.usernameSubject.next(username);  
    this.roleSubject.next(role);
    
    // Fetch the correct username
    this.fetchUsernameFromBackend(token);
    
    console.log('User logged in:', username);
  }

  logout(): void {
   
    localStorage.removeItem('authToken');
    localStorage.removeItem('username');
    localStorage.removeItem('role');
     console.log("i am logout")

    // Reset the login state
    this.loggedInSubject.next(false);
    this.usernameSubject.next('');
    this.roleSubject.next('');
  }

  private fetchUsernameFromBackend(token: string): void {
    const apiUrl = 'fetch-username';  

    
    this.jwtService.authorizeRequest(token, apiUrl).subscribe(
      (response: any) => {
        if (response.username) {
          
          this.usernameSubject.next(response.username);
          localStorage.setItem('username', response.username);  
        }
      },
      error => {
        console.error('Error fetching username from backend:', error);
       
        this.loggedInSubject.next(false);
        this.usernameSubject.next('');
      }
    );
  }

  getRole(): string {
    return localStorage.getItem('role') || '';
  }


  getLoggedInEmail(): string {
    const token = localStorage.getItem('authToken'); 
    if (token) {
      const tokenParts = token.split('.');
      if (tokenParts.length === 3) {
        const payload = tokenParts[1]; 
        const decodedPayload = atob(payload); 
        const parsedPayload = JSON.parse(decodedPayload); 
        
        return parsedPayload?.sub || ''; 
        
      }
    }
    return '';
  }

  
}
