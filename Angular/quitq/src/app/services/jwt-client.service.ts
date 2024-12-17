import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class JwtClientService {

  baseURL: string = 'http://localhost:8080/api/';

  constructor(private http: HttpClient) {}

  getGeneratedToken(requestBody: any, role: string) {
    let authURL = '';
    switch (role) {
      case 'customer':
        authURL = 'customer/login';
        break;
      case 'supplier':
        authURL = 'supplier/login';
        break;
      case 'admin':
        authURL = 'admin/login';
        break;
      default:
        throw new Error('Role not recognized');
    }

    return this.http.post(this.baseURL + authURL, requestBody, {
      responseType: 'text' as 'json'
    });
  }

  authorizeRequest(token: string, endpoint: string): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`,
      'Access-Control-Allow-Origin': 'http://localhost:4200'
    });

    return this.http.get(this.baseURL + endpoint, { headers });
  }
}
