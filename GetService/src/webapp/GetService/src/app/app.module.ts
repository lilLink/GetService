import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule  } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { AddContractComponent } from './components/add-contract/add-contract.component';
import { ViewContractComponent } from './components/view-contract/view-contract.component';
import { AuthorizationComponent } from './components/authorization/authorization.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { HeaderlogComponent } from './components/headerlog/headerlog.component';
import { ContractsComponent } from './components/contracts/contracts.component';
import { AppConfig, APP_CONFIG } from './app.config';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AuthorizationComponent,
    RegistrationComponent,
    HeaderlogComponent,
    ContractsComponent,
    HeaderComponent,
    AddContractComponent,
    ViewContractComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    { provide: APP_CONFIG, useValue: AppConfig }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
