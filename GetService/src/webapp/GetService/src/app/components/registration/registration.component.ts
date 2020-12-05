import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent implements OnInit {

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
