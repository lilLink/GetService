import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { UserInfo } from '../models/userinfo.model';

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
export class UserInfoService {

  constructor(private http: HttpClient) { }

  private useriinfoURL = 'http://localhost:8080/info/';

  public findAll(){
    return this.http.get<UserInfo[]>(this.useriinfoURL, httpOptions);
  }

  public findById(infoId: number): Observable<UserInfo> {
    return this.http.get<UserInfo>(this.useriinfoURL + infoId, httpOptions);
  }

  public update(info: UserInfo): Observable<UserInfo> {
    return this.http.put<UserInfo>(this.useriinfoURL, info, httpOptions);
  }

  public deleteById(info: UserInfo) {
    return this.http.delete(this.useriinfoURL + info.infoId, httpOptions);
  }

  public create(info: UserInfo) {
    return this.http.post<UserInfo>(this.useriinfoURL , info, httpOptions);
  }
}