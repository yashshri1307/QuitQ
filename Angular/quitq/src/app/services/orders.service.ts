import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'; // Import HttpHeaders
import { catchError, Observable, throwError } from 'rxjs';
import { Orders } from '../models/orders';
import { ProductService } from './product.service';

@Injectable({
  providedIn: 'root',
})
export class OrdersService {
   baseUrl:string = "http://localhost:8080/api/orders"; 

  constructor(private http: HttpClient,private products:ProductService) {}

  
  private getHeaders(): HttpHeaders {
    const token = localStorage.getItem('authToken');
    if (!token) {
      console.error('Token not found');
      throw new Error('Token not found'); 
    }
    return new HttpHeaders({ Authorization: `Bearer ${token}` });
  }

  // Add Order
  addOrder(order: Orders): Observable<Orders> {
    const token = localStorage.getItem('authToken');
    const headers = { Authorization: `Bearer ${token}` };
    console.log("comning")

     return this.http.post<Orders>(`${this.baseUrl}/add`, order, { headers }).pipe(
          catchError((error) => {
            console.log("Error response:", error);
            return throwError(() => error);
          })
        );
  }

  // Get Order by ID
  getOrderById(id: number): Observable<any> {
    const headers = this.getHeaders();

    return this.http.get(`${this.baseUrl}/getorder/${id}`, { headers }).pipe(
      catchError((error) => {
        console.error('Error response:', error);
        return throwError(() => error);
      })
    );
  }

  // Get All Orders
  getAllOrders(): Observable<any[]> {
    const headers = this.getHeaders();

    return this.http.get<any[]>(`${this.baseUrl}/getall`, { headers }).pipe(
      catchError((error) => {
        console.error('Error response:', error);
        return throwError(() => error);
      })
    );
  }

  // Delete Order by ID
  deleteOrderById(id: number): Observable<string> {
    const headers = this.getHeaders();

    return this.http.delete(`${this.baseUrl}/deleteorder/${id}`, { headers, responseType: 'text' }).pipe(
      catchError((error) => {
        console.error('Error response:', error);
        return throwError(() => error);
      })
    );
  }

  // Get Orders by Status
  getOrdersByStatus(status: string): Observable<any[]> {
    const headers = this.getHeaders();

    return this.http.get<any[]>(`${this.baseUrl}/getorderbystatus/${status}`, { headers }).pipe(
      catchError((error) => {
        console.error('Error response:', error);
        return throwError(() => error);
      })
    );
  }
}
