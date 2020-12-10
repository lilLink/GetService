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
      'Access-Control-Max-Age': '3600'
    })
  };

  @Injectable({
      providedIn: 'root'
  })
  export class ContractService{
    constructor(private http: HttpClient) { }

    private contractURL = 'http://localhost:8080/contract/';

    public findAll(){
      return this.http.get<Contract[]>(this.contractURL + "all", httpOptions);
    }
  
    public findById(contractId: any): Observable<Contract> {
      return this.http.get<Contract>(this.contractURL + contractId, httpOptions);
    }
  
    public update(contract: Contract): Observable<Contract> {
      console.log(contract);
      return this.http.put<Contract>(this.contractURL + 'update', contract, httpOptions);
    }
  
    public deleteById(contract: Contract) {
      console.log(contract);
      return this.http.delete(this.contractURL + "delete/" + contract.contractId, httpOptions);
    }
  
    public create(contract: Contract) {
      return this.http.post<Contract>(this.contractURL + "add" , contract, httpOptions);
    }

  }