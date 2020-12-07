import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { AddContractComponent } from './components/add-contract/add-contract.component';
import { ViewContractComponent } from './components/view-contract/view-contract.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AddContractComponent,
    ViewContractComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
