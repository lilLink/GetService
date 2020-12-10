import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule  } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './components/header/header.component';
import { ViewContractsComponent } from './components/view-contracts/view-contracts.component';
import { AuthoComponent } from './components/autho/autho.component';
import { RegistComponent } from './components/regist/regist.component';
import { AddContractComponent } from './components/add-contract/add-contract.component';
import { FeedbackComponent } from './components/feedback/feedback.component';
import { AppConfig, APP_CONFIG } from './app.config';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ViewContractsComponent,
    AuthoComponent,
    RegistComponent,
    AddContractComponent,
    FeedbackComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
    
  ],
  providers: [
    { provide: APP_CONFIG, useValue: AppConfig }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
