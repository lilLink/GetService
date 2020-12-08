import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Skill } from '../models/skill.model';

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
export class SkillService {

  constructor(private http: HttpClient) { }

  private skillURL = 'http://localhost:8080/skill/';

  public findAll(){
    return this.http.get<Skill[]>(this.skillURL, httpOptions);
  }

  public findById(skillId: number): Observable<Skill> {
    return this.http.get<Skill>(this.skillURL + skillId, httpOptions);
  }

  public update(skill: Skill): Observable<Skill> {
    return this.http.put<Skill>(this.skillURL, skill, httpOptions);
  }

  public deleteById(skill: Skill) {
    return this.http.delete(this.skillURL + skill.skillId, httpOptions);
  }

  public create(skill: Skill) {
    return this.http.post<Skill>(this.skillURL , skill, httpOptions);
  }

}
