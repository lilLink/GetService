import { Component, OnInit } from '@angular/core';
import { Feedback } from 'src/app/models/feedback.model';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.scss']
})
export class FeedbackComponent implements OnInit {

  comments: Feedback[];

  constructor() { }

  ngOnInit(): void {
  }

}
