import { Component, Inject } from '@angular/core';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { ComfirmComponent } from '../confirm/comfirm.component';

import { APP_CONFIG, IAppConfig } from '../app.config';

@Component({
  selector: 'app-password-forgot',
  templateUrl: './password-forgot.component.html',
  styleUrls: ['./password-forgot.component.scss']
})
export class PasswordForgotComponent {

  userLogin = { username: '' };

  private resetPasswordUrl = this.rabotyNETEndpoint.apiEndpoint + '/password/reset';

  constructor(private http: HttpClient, private router: Router, public dialog: MatDialog, @Inject(APP_CONFIG) private rabotyNETEndpoint: IAppConfig) {
  }

  forgotPassword() {
    const authHeader = {
      'Access-Control-Allow-Origin': 'http://localhost:4200',
      'Content-Type': 'application/json',
      'Access-Control-Allow-Credentials': 'true',
    };

    const httpOptions = {
      headers: new HttpHeaders(authHeader), withCredentials: true
    };

    const observable = this.http.post<any>(this.resetPasswordUrl, this.userLogin, httpOptions);
    observable.subscribe(() => {
    },
      () => {
        this.openErrorModal('Please check the correctness of the email ');
      },
      () => {
        this.openSuccessModal('Please check mail for further instructions!');
        this.router.navigate(['/vacancies']);
      }
    );
  }

  public openErrorModal(name: String) {
    this.dialog.open(ComfirmComponent, { data: { name } });
  }

  public openSuccessModal(name: String) {
    this.dialog.open(ComfirmComponent, { data: { name } });
  }

}
