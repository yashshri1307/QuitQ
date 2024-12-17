import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtClientService } from './jwt-client.service';
import { product } from '../models/Product';
import { catchError, Observable, tap, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  baseURL:string="http://localhost:8080/api/product"
  
    constructor(private jwtService: JwtClientService,private http:HttpClient) { }

  
  addProduct(product: product): Observable<product> {
    console.log("productobj=" + product);
  
    const token = localStorage.getItem('authToken');
    if (!token) {
      console.error('Token not found');
      return throwError(() => new Error('Token not found')); 
    }
   
    const headers = { Authorization: `Bearer ${token}` };
  
   
    return this.http.post<product>(`${this.baseURL}/add`, product, { headers }).pipe(
      catchError((error) => {
        console.log("Error response:", error);
        return throwError(() => error);
      })
    );
  }


getAllProducts(): Observable<any[]> {
  const token = localStorage.getItem('authToken');
  let options = {};

  
  if (token) {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    options = { headers }; 
  }
  console.log(" i am boss")
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


getProductById(id:number): Observable<any[]> {
  const token = localStorage.getItem('authToken')!;
  const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
  return this.http.get<any[]>(`${this.baseURL}/getproduct/${id}`, { headers }).pipe(
    catchError((error) => {
      console.error('Error fetching products:', error);
      return throwError(() => error);
    })
  );
}
getProductBySupplierId(id:number): Observable<any[]> {
  const token = localStorage.getItem('authToken')!;
  const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
  return this.http.get<any[]>(`${this.baseURL}/getproductBySupplierId/${id}`, { headers }).pipe(
    catchError((error) => {
      console.error('Error fetching products:', error);
      return throwError(() => error);
    })
  );
}

// Delete a product
deleteProduct(productId: number): Observable<void> {
  const token = localStorage.getItem('authToken')!;
  const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
  return this.http.delete<void>(`${this.baseURL}/delete/${productId}`, { headers }).pipe(
    catchError((error) => {
      console.error('Error deleting product:', error);
      return throwError(() => error);
    })
  );
}
  
updateProduct(id:number,product: product): Observable<product> {
  console.log("productobj=" + product);

  const token = localStorage.getItem('authToken');
  if (!token) {
    console.error('Token not found');
    return throwError(() => new Error('Token not found')); 
  }

  // Add token to Authorization header
  const headers = { Authorization: `Bearer ${token}` };

   console.log("id="+id)
   console.log("prod="+product)
  // Send the HTTP POST request with the headers
  return this.http.put<product>(`${this.baseURL}/updateproduct/${id}`, product, { headers }).pipe(
    catchError((error) => {
      console.log("Error response:", error);
      return throwError(() => error);
    })
  );
}
}


