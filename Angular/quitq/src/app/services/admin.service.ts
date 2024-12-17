import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, tap, throwError } from 'rxjs';
import { Admin } from '../models/Admin';
import { JwtClientService } from './jwt-client.service';

@Injectable({
  providedIn: 'root'
})
export class AdminService {


  baseURL:string="http://localhost:8080/api/admins"
  
    constructor(private http:HttpClient,private jwtService:JwtClientService) { }
  
    login(username: string, password: string): Observable<any> {
  
      const body = {username, password };
  
      return this.http.post(this.baseURL+"/login", body, { responseType: 'text' });
      
    }

    addAdmin(admin:Admin):Observable<any>{
      return this.http.post(`${this.baseURL}/add`,admin);
    };

    getAdminByEmail(email: string): Observable<any> {
      const token = localStorage.getItem('authToken')!;
      if (!token) {
        console.error('Token not found');
        return new Observable(); 
      }
      return this.jwtService.authorizeRequest(token, `admins/getAdminByEmail/${email}`);
    }

getAll(): Observable<any[]> {
  const token = localStorage.getItem('authToken');
  let options = {};

  
  if (token) {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    options = { headers }; 
  }
  return this.http.get<any[]>(`${this.baseURL}/getall`, options).pipe(

    tap((response: any) => {
      console.log('Fetched products:', response);
    }),
    catchError((error) => {
      console.error('Error fetching products:', error);
      return throwError(() => error);
    })
  );
}

// Delete a admin
deleteAdmin(adminId: number): Observable<void> {
  const token = localStorage.getItem('authToken')!;
  const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
  return this.http.delete<void>(`${this.baseURL}/delete/${adminId}`, { headers }).pipe(
    catchError((error) => {
      console.error('Error deleting product:', error);
      return throwError(() => error);
    })
  );
}
}

