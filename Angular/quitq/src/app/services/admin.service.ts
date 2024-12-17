import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {


  baseURL:string="http://localhost:8080/api/admin"
  
    constructor(private http:HttpClient) { }
  
    login(username: string, password: string): Observable<any> {
  
      const body = {username, password };
  
      return this.http.post(this.baseURL+"/login", body, { responseType: 'text' });
      
    }
}


// CODE FOR ADD ADMIN --------------------------------------------------------------------

// import { HttpClient } from '@angular/common/http';
// import { Injectable } from '@angular/core';
// import { Observable } from 'rxjs';
// import { admin } from '../models/Admin';

// @Injectable({
//   providedIn: 'root'
// })
// export class AdminService {

//   baseURL: string = "http://localhost:8080/api/admin";

//   constructor(private http: HttpClient) { }

//   login(username: string, password: string): Observable<any> {
//     const body = { username, password };
//     return this.http.post(this.baseURL + "/login", body, { responseType: 'text' });
//   }

//   // Method to add a new admin
//   addAdmin(admin: Admin): Observable<Admin> {
//     return this.http.post<Admin>(`${this.baseURL}/add`, admin);
//   }

//   // Fetch all admins
//   getAllAdmins(): Observable<Admin[]> {
//     return this.http.get<Admin[]>(`${this.baseURL}/list`);
//   }
// }

