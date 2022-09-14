import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClient, HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { ItemDetailsComponent } from './item-details/item-details.component';
import { ProfileDisplayComponent } from './profile-display/profile-display.component';
import { OrderHistoryComponent } from './order-history/order-history.component';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    NavBarComponent,
    LoginComponent,
    ItemDetailsComponent,
    ProfileDisplayComponent,
    OrderHistoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
