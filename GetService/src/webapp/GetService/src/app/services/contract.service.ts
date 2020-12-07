import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Contract } from '../models/contract';

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
export class ContractService {

  constructor(private http: HttpClient) { }

  private contractURL = 'http://localhost:8080/contract/';

  public findAll(){
    return this.http.get<Contract[]>(this.contractURL + "view", httpOptions);
  }

  public findById(contractId: any): Observable<Contract> {
    return this.http.get<Contract>(this.contractURL + contractId, httpOptions);
  }

  public update(contract: Contract): Observable<Contract> {
    return this.http.put<Contract>(this.contractURL, contract, httpOptions);
  }

  public deleteById(contract: Contract) {
    return this.http.delete(this.contractURL + contract.id, httpOptions);
  }

  public create(contract: Contract) {
    return this.http.post<Contract>(this.contractURL + "add" , contract, httpOptions);
  }

}
