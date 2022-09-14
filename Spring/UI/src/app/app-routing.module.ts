import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CatalogDisplayComponent } from './catalog-display/catalog-display.component';
import { CheckoutcartComponent } from './checkoutcart/checkoutcart.component';
import { ItemDetailsComponent } from './item-details/item-details.component';
import { LoginComponent } from './login/login.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { OrderhistoryComponent } from './orderhistory/orderhistory.component';
import { PersonalInfoComponent } from './personal-info/personal-info.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { MatToolbarModule } from '@angular/material/toolbar';


const routes: Routes = [
  {path: "welcome-component", component: WelcomeComponent},
  {path: "login", component: LoginComponent},
  {path: "catalog", component: CatalogDisplayComponent},
  {path: "nav-bar", component: NavBarComponent},
  {path: "orderhistory", component: OrderhistoryComponent},
  {path: "checkoutcart", component: CheckoutcartComponent},
  {path: "personal-info", component: PersonalInfoComponent},
  {path: "itemDetails/:id", component: ItemDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
