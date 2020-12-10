import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-regist',
  templateUrl: './regist.component.html',
  styleUrls: ['./regist.component.scss']
})
export class RegistComponent implements OnInit {

  checked: boolean = true;

  constructor() { }

  checkPass(input, repeat) {
    if(input == repeat){
      this.checked = true;
    }
    else{
      this.checked = false;
    }
    return null;
  }

  ngOnInit(): void {
  }

}
