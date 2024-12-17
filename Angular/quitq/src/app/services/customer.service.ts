import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { customer } from '../models/Customer';
import { catchError, Observable, throwError } from 'rxjs';
import { JwtClientService } from './jwt-client.service';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  baseURL:string="http://localhost:8080/api/customer"

  constructor(private jwtService: JwtClientService,private http:HttpClient) { }

  login(username: string, password: string): Observable<any> {

    const body = {username, password };

    return this.http.post(this.baseURL+"/login", body, { responseType: 'text' });
    
  }

  addCustomer(customer:customer):Observable<customer>{
    return this.http.post<customer>(this.baseURL+"/add",customer).pipe(
      catchError((error) => {
        console.log("Error response:", error);
        return throwError(() => error);
      })
    );
  }

  
  getCustomerByEmail(email: string): Observable<any> {
    console.log("email successfully received in customerservice="+email)
    const token = localStorage.getItem('authToken')!;
    console.log("incusS token="+token)
    if (!token) {
      console.error('Token not found');
      return new Observable(); 
    }
    return this.jwtService.authorizeRequest(token, `customer/getcustomerByEmail/${email}`);
  }
}


