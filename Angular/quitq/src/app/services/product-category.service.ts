import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';
import { ProductCategory } from '../models/ProductCategory';

@Injectable({
  providedIn: 'root',
})
export class ProductCategoryService {
  private baseUrl = 'http://localhost:8080/api/productcategory'; 

  constructor(private http: HttpClient) {}


  addProductCategory(productCategory: ProductCategory): Observable<any> {
    console.log('Product Category to Add:', productCategory);
  
    
    const token = localStorage.getItem('authToken');
    if (!token) {
      console.error('Authentication token not found');
      return throwError(() => new Error('User is not authenticated'));
    }
  
    
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`,
      'Content-Type': 'application/json', 
    });
  
   
    return this.http.post<ProductCategory>(`${this.baseUrl}/add`, productCategory, { headers }).pipe(
      catchError((error) => {
        console.error('Error response:', error);
        let errorMessage = 'An unknown error occurred';
  
        if (error.status === 403) {
          errorMessage = 'You do not have permission to perform this action.';
        } else if (error.status === 401) {
          errorMessage = 'Your session has expired. Please log in again.';
        } else if (error.error && error.error.message) {
          errorMessage = error.error.message; 
        }
  
       
  
        return throwError(() => new Error(errorMessage));
      })
    );
  }
  
  

  updateProductCategory(productCategory: ProductCategory): Observable<ProductCategory> {
    const token = localStorage.getItem('authToken');
    if (!token) {
      console.error('Authentication token not found');
      return throwError(() => new Error('User is not authenticated'));
    }
  
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`,
      'Content-Type': 'application/json',
    });
  
    return this.http.put<ProductCategory>(
      `${this.baseUrl}/update`,
      productCategory,
      { headers }
    ).pipe(
      catchError((error) => {
        console.error('Error updating product category:', error);
        const errorMessage = error.error?.message || 'Error updating product category';
        return throwError(() => new Error(errorMessage));
      })
    );
  }
  
  

  getProductCategoryById(categoryId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/getbyid/${categoryId}`);
  }

  getAllProductCategories(): Observable<ProductCategory[]> {
    const token = localStorage.getItem('authToken');
    if (!token) {
      console.error('Token not found');
      return throwError(() => new Error('Token not found')); // Handle missing token
    }
  
    // Add token to Authorization header
    const headers = new HttpHeaders({ Authorization: `Bearer ${token}` });
  
    // Send the HTTP GET request with the headers
    return this.http.get<ProductCategory[]>(`${this.baseUrl}/getall`, { headers }).pipe(
      catchError((error) => {
        console.log('Error response:', error);
        return throwError(() => error);
      })
    );
  }
  

   //  return this.http.get<ProductCategory[]>(`${this.baseUrl}/getall`);

   deleteProductCategoryById(categoryId: number): Observable<any> {
    const token = localStorage.getItem('authToken');
    if (!token) {
      console.error('Token not found');
      return throwError(() => new Error('Token not found')); // Handle missing token
    }
  
    // Add token to Authorization header
    const headers = new HttpHeaders({ Authorization: `Bearer ${token}` });
  
    // Send the HTTP DELETE request with the headers
    return this.http.delete(`${this.baseUrl}/deletebyid/${categoryId}`, { headers }).pipe(
      catchError((error) => {
        console.log('Error response:', error);
        return throwError(() => error);
      })
    );
  }
  
  }

 