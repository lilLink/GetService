import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Category } from '../models/category';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': '*',
    'Access-Control-Allow-Methods': 'POST, GET, PUT, OPTIONS, DELETE',
    'Access-Control-Max-Age': '3600',
    'Access-Control-Allow-Headers': 'X-requested-with, Content-Type'
  })
};

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http: HttpClient) { }

  private categoryURL = 'http://localhost:8080/category/';

  public findAll(){
    return this.http.get<Category[]>(this.categoryURL, httpOptions);
  }

  public findById(categoryId: number): Observable<Category> {
    return this.http.get<Category>(this.categoryURL + categoryId, httpOptions);
  }
}