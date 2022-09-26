import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const AUTH_API = 'http://localhost:8080/api';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(credentials): Observable<any> {
    return this.http.post(AUTH_API + '/auth/login', {
      username: credentials.username,
      password: credentials.password
    }, httpOptions);
  }

  register(account): Observable<any> {
    return this.http.post(AUTH_API + '/auth/register', {
      accountName: account.name,
      username: account.username,
      password: account.password,
      roles : [2]
    }, httpOptions);
  }
}
