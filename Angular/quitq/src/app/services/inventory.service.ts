import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { catchError, Observable, tap, throwError } from 'rxjs';
import { JwtClientService } from './jwt-client.service';
import { Inventory } from '../models/Inventory';

@Injectable({
  providedIn: 'root',
})
export class InventoryService {
  private baseUrl = 'http://localhost:8080/api/inventory'; 

  constructor(private jwtService: JwtClientService, private http: HttpClient) {}

  getAllInventories(): Observable<Inventory[]> {
    const token = localStorage.getItem('authToken');
    if (!token) {
      console.error('Token not found');
      return throwError(() => new Error('Token not found')); 
    }

   
    const headers = new HttpHeaders({ Authorization: `Bearer ${token}` });

    
    return this.http.get<Inventory[]>(`${this.baseUrl}/getall`, { headers }).pipe(
      catchError((error) => {
        console.error('Error response:', error);
        return this.handleError(error);
      })
    );
  }

  addInventory(inventory: Inventory): Observable<Inventory[]> {
    const token = localStorage.getItem('authToken');
    if (!token) {
      console.error('Token not found');
      return throwError(() => new Error('Token not found')); 
    }

    const headers = { Authorization: `Bearer ${token}` };

    return this.http.post<Inventory[]>(`${this.baseUrl}/add`, inventory, { headers }).pipe(
      catchError((error) => {
        console.error('Error response:', error);
        return this.handleError(error);
      })
    );
  }

  updateInventory(inventory: Inventory): Observable<Inventory> {
    const token = localStorage.getItem('authToken');
    if (!token) {
      console.error('Token not found');
      return throwError(() => new Error('Token not found'));
    }

    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`
    });

    return this.http.put<Inventory>(`${this.baseUrl}/update`, inventory, { headers }).pipe(
      catchError((error) => {
        console.error('Error response:', error);
        return this.handleError(error);
      })
    );
  }

  deleteInventory(id: number): Observable<any> {
    const token = localStorage.getItem('authToken');
    if (!token) {
      console.error('Token not found');
      return throwError(() => new Error('Token not found')); 
    }

    const headers = new HttpHeaders({ Authorization: `Bearer ${token}` });

    return this.http.delete(`${this.baseUrl}/deletebyid/${id}`, { headers }).pipe(
      catchError((error) => {
        console.error('Error response:', error);
        return this.handleError(error);
      }),
      // On success, show an alert
      tap(() => {
        alert('Inventory deleted successfully!');
      })
    );
  }

  private handleError(error: HttpErrorResponse) {
    
    if (error.error instanceof ErrorEvent) {
      
      return throwError(() => new Error('An error occurred: ' + error.error.message));
    } else {
      // Server-side error
      switch (error.status) {
        case 400:
          return throwError(() => new Error('Invalid ID provided.'));
        case 404:
          return throwError(() => new Error('Inventory not found.'));
        case 500:
          return throwError(() => new Error('Internal server error.'));
        default:
          return throwError(() => new Error('Unknown error occurred.'));
      }
    }
  }
}
