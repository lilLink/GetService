import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddContractComponent } from './components/add-contract/add-contract.component';
import { AuthorizationComponent } from './components/authorization/authorization.component';
import { ContractsComponent } from './components/contracts/contracts.component';
import { HeaderComponent } from './components/header/header.component';
import { HeaderlogComponent } from './components/headerlog/headerlog.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { ViewContractComponent } from './components/view-contract/view-contract.component';

const routes: Routes = [
  {path: 'authorization', component: AuthorizationComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'header', component: HeaderComponent},
  {path: 'headerlog', component: HeaderlogComponent},
  {path: 'contract/add', component: AddContractComponent},
  {path: 'contract/view', component: ViewContractComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
