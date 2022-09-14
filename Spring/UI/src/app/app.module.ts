import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { SearchBarComponent } from './search-bar/search-bar.component';
import { CatalogDisplayComponent } from './catalog-display/catalog-display.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import { RouterModule, Routes } from '@angular/router';
import { OrderhistoryComponent } from './orderhistory/orderhistory.component';
import { CheckoutcartComponent } from './checkoutcart/checkoutcart.component';
import { PersonalInfoComponent } from './personal-info/personal-info.component';


@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    NavBarComponent,
    LoginComponent,
    SearchBarComponent,
    CatalogDisplayComponent
    OrderhistoryComponent,
    CheckoutcartComponent,
    PersonalInfoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatToolbarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }