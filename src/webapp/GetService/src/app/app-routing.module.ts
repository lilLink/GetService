import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


import { HeaderComponent } from './components/header/header.component';
import { ViewContractsComponent } from './components/view-contracts/view-contracts.component';
import { AuthoComponent } from './components/autho/autho.component';
import { RegistComponent } from './components/regist/regist.component';
import { AddContractComponent } from './components/add-contract/add-contract.component';
import { FeedbackComponent } from './components/feedback/feedback.component';
 
const routes: Routes = [
  {path: 'header', component: HeaderComponent},
  {path: 'contract/view', component: ViewContractsComponent},
  {path: 'autho', component: AuthoComponent},
  {path: 'regist', component: RegistComponent},
  {path: 'contract/add', component: AddContractComponent},
  {path: 'feedback', component: FeedbackComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
