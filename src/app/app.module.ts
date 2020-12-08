import { AppConfig, APP_CONFIG } from './app.config';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule, HttpClientXsrfModule } from '@angular/common/http';

import { MatDatepickerModule, MatInputModule, MatNativeDateModule, MAT_DATE_LOCALE, MatSidenavModule } from '@angular/material';

import { ProfileComponent } from './profile/profile.component';

import { VacancyComponent } from './vacancy/vacancy.component';
import { EditVacancyComponent } from './vacancy/edit-vacancy/edit-vacancy.component';
import { ClosedVacancyComponent } from './vacancy/closed-vacancy/closed-vacancy.component'

import { CompanyComponent } from './company/company.component';
import { AddCompanyComponent } from './company/add-company/add-company.component';



import { UserComponent } from './user/user.component';
import { AddUserComponent } from './user/add-user/add-user.component';


import { AppRoutingModule } from './app-routing.module';
import { BsDropdownModule } from 'ngx-bootstrap';

import { AppComponent } from './app.component';

import { PerfectScrollbarModule } from 'ngx-perfect-scrollbar';
import { PERFECT_SCROLLBAR_CONFIG } from 'ngx-perfect-scrollbar';
import { PerfectScrollbarConfigInterface } from 'ngx-perfect-scrollbar';
import { ComfirmComponent } from './confirm/comfirm.component';
import { MatDialogModule } from '@angular/material';
import { RegistrationconfirmComponent } from './confirm/registrationconfirm/registrationconfirm.component';
import { ApproveCompanyComponent } from './company/approve-company/approve-company.component';

import { ViewCompanyComponent } from './company/view-company/view-company.component';
import { AuthenticationService } from './services/authentication.service';

import { AuthInterceptor, ErrorInterceptor } from './_helpers';
import { AccessDeniedPageComponent } from './access-denied-page/access-denied-page.component';

import { MyCompanyComponent } from './company/my-company/my-company.component';
import { PasswordForgotComponent } from './password-forgot/password-forgot.component';
import { PasswordRestoreComponent } from './password-restore/password-restore.component';
import { ViewVacancyComponent } from './vacancy/view-vacancy/view-vacancy.component';
import { AccessNonauthorizedPageComponent } from './access-nonauthorized-page/access-nonauthorized-page.component';
import { HotVacancyComponent } from './vacancy/hot-vacancy/hot-vacancy.component';

const DEFAULT_PERFECT_SCROLLBAR_CONFIG: PerfectScrollbarConfigInterface = {
  suppressScrollX: true
};

@NgModule({
  declarations: [
    AppComponent,
    ProfileComponent,
    VacancyComponent,
    EditVacancyComponent,
    ClosedVacancyComponent,
    CompanyComponent,
    AddCompanyComponent,
    UserComponent,
    AddUserComponent,
    
    ComfirmComponent,
    RegistrationconfirmComponent,
    ApproveCompanyComponent,
    ViewCompanyComponent,
    AccessDeniedPageComponent,
    
    MyCompanyComponent,
    PasswordForgotComponent,
    PasswordRestoreComponent,
    
    ViewVacancyComponent,
    AccessNonauthorizedPageComponent,
    HotVacancyComponent,
    AccessNonauthorizedPageComponent,

    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    BrowserAnimationsModule,
    MatDatepickerModule, MatInputModule, MatNativeDateModule,
    HttpClientModule,
    HttpClientXsrfModule.withOptions({ cookieName: 'XSRF-TOKEN', headerName: 'X-XSRF-TOKEN' }),
    ReactiveFormsModule,
    AppRoutingModule,
    PerfectScrollbarModule,
    MatDialogModule,
    BsDropdownModule.forRoot(), MatSidenavModule
  ],
  bootstrap: [AppComponent],
  entryComponents: [ComfirmComponent],
  providers: [AuthenticationService,
    { provide: MAT_DATE_LOCALE, useValue: 'uk-UK' },
    { provide: PERFECT_SCROLLBAR_CONFIG, useValue: DEFAULT_PERFECT_SCROLLBAR_CONFIG },
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
    { provide: APP_CONFIG, useValue: AppConfig }
  ]
})
export class AppModule { }
