import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent implements OnInit {

  checked: boolean = true;
  user: User = new User();
 
  constructor(private router: Router, private route: ActivatedRoute) { }

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

  /*insert(): void {
    this.resumeService.insert(this.user)
      .subscribe(data => {
        if (data != null) {
          this.router.navigate(['/resume/user']);
        } else {
          alert("Validation problem has been occured");
        }
      });
  };*/

}
