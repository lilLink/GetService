import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Contract } from '../models/contract.model';


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
  export class ContractService{
    constructor(private http: HttpClient) { }

  }