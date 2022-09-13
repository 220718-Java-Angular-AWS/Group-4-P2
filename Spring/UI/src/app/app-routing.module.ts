import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CheckoutcartComponent } from './checkoutcart/checkoutcart.component';
import { LoginComponent } from './login/login.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { OrderhistoryComponent } from './orderhistory/orderhistory.component';
import { WelcomeComponent } from './welcome/welcome.component';

const routes: Routes = [
  {path: "welcome-compoent", component: WelcomeComponent},
  {path: "login", component: LoginComponent},
  {path: "nav-bar", component: NavBarComponent},
  {path: "orderhistory", component: OrderhistoryComponent},
  {path: "checkoutcart", component: CheckoutcartComponent},
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
