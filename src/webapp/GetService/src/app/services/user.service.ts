import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { User } from '../models/user.model';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': 'http://localhost:4200/',
    'Access-Control-Allow-Methods': 'POST, GET, PUT, OPTIONS, DELETE',
    'Access-Control-Max-Age': '3600',
    'Access-Control-Allow-Headers': 'X-requested-with, Content-Type'
  })
};

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  private userURL = 'http://localhost:8080/user/';

  public findAll(){
    return this.http.get<User[]>(this.userURL, httpOptions);
  }

  public findById(userId: number): Observable<User> {
    return this.http.get<User>(this.userURL + userId, httpOptions);
  }

  public update(user: User): Observable<User> {
    return this.http.put<User>(this.userURL, user, httpOptions);
  }

  public deleteById(user: User) {
    return this.http.delete(this.userURL + user.userId, httpOptions);
  }

  public create(user: User) {
    return this.http.post<User>(this.userURL , user, httpOptions);
  }
}