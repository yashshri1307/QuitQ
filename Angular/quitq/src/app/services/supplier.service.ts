import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { supplier } from '../models/Supplier';
import { JwtClientService } from './jwt-client.service';

@Injectable({
  providedIn: 'root'
})
export class SupplierService {


  baseURL:string="http://localhost:8080/api/supplier"

  constructor(private jwtService: JwtClientService,private http:HttpClient) { }

  login(username:string,password:string): Observable<any> {

    const body={username,password};

    return this.http.post(this.baseURL+"/login",body, { responseType:'text' });
  }

  addSupplier(supplier:supplier):Observable<supplier>{
      return this.http.post<supplier>(this.baseURL+"/add",supplier).pipe(
        catchError((error) => {
          console.log("Error response:", error);
          return throwError(() => error);
        })
      );
    }


    getSupplierByEmail(email: string): Observable<any> {
      console.log("email successfully received in supplierservice="+email)
      const token = localStorage.getItem('authToken')!;
      console.log("insppsS token="+token)
      if (!token) {
        console.error('Token not found');
        return new Observable();
      }
      return this.jwtService.authorizeRequest(token, `supplier/getsupplierByEmail/${email}`);
    }

    
}
