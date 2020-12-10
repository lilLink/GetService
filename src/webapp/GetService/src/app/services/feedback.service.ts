import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Feedback } from '../models/feedback.model';


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
export class FeedbackService{
    constructor(private http: HttpClient) { }

    private feedbackURL = 'http://localhost:8080/feedback/';

    public findAll(){
        return this.http.get<Feedback[]>(this.feedbackURL, httpOptions);
      }
    
      public findById(feedbackId: any): Observable<Feedback> {
        return this.http.get<Feedback>(this.feedbackURL + feedbackId, httpOptions);
      }
    
      public update(feedback: Feedback): Observable<Feedback> {
        console.log(feedback);
        return this.http.put<Feedback>(this.feedbackURL + feedback.feedbackId, feedback, httpOptions);
      }
    
      public deleteById(feedback: Feedback) {
        console.log(feedback);
        return this.http.delete(this.feedbackURL + feedback.feedbackId, httpOptions);
      }
    
      public create(feedback: Feedback) {
        return this.http.post<Feedback>(this.feedbackURL, feedback, httpOptions);
      }

}