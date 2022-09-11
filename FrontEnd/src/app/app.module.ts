import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavigationComponent } from './navigation/navigation.component';
import { LoginComponent } from './login/login.component';
import { CartComponent } from './cart/cart.component';
import { ProfileComponent } from './profile/profile.component';
import { ItemsComponent } from './items/items.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { HistoryComponent } from './history/history.component';
import { ServerComponent } from './server/server.component';
import { FormsModule } from '@angular/forms';
import { UsersService } from './users.service';
import { LoginService } from './login.service';
import { catalogDetailsService } from './catalogDetails.service';
import { CatalogService } from './catalog.service';
import { CartService } from './cart.service';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    LoginComponent,
    CartComponent,
    ProfileComponent,
    ItemsComponent,
    CheckoutComponent,
    HistoryComponent,
    ServerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [UsersService, LoginService, catalogDetailsService, CatalogService, CartService],
  bootstrap: [AppComponent]
})
export class AppModule { }
