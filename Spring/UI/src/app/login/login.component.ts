import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cart } from '../cart';
import { CartService } from '../cart.service';
import { CreateCart } from '../createCart';
import { Login } from '../login';
import { LoginService } from '../login.service';
import { Users } from '../user';
import { HttpResponse } from '@angular/common/http'
import { Observable } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  _service: LoginService;
  _router: Router;
  _cartService: CartService;

  userName: string = "";
  password: string = "";


  constructor(service: LoginService, router: Router, cartService: CartService) {
    this._service = service;
    this._router = router;
    this._cartService = cartService;


  }

  ngOnInit(): void {
  }

  // To Do: 
  // check to see if user exists 
  // check to see there is a cart for the user that is false already 


  // need to reroute 

  onLogin(): void {
    let loginReturn: boolean = true;

    let now = new Date();
    let formalDate = now.getMonth() + "/" + now.getDate() + "/" + now.getFullYear()


    let userReturned: Users;

    let loginCredintials: Login =
    {
      username: this.userName,
      password: this.password
    };
    let observable: Observable<HttpResponse<Object>> = this._service.reqTest(loginCredintials);

    observable.subscribe((response: HttpResponse<Object>) => {
      console.log("Observable has emitted a value...");
      if (response.status == 200) {
        userReturned = response.body as Users
        console.log("response body", response.body)
        
        console.log("VIEWING USER: ", userReturned.userId)
        //good auth
      }
      else {
        alert("Bad username and/or password!")
        //bad auth
      }

      if (userReturned === null || userReturned === undefined) {
        // didnt work 
        console.log(" MADE INTO IF STATEMENT USER DOESNT EXISTS")
      }

      else {
        // good thing 
        console.log("User is defined and we are ready to store a token locally: ", userReturned);

        localStorage.setItem("currentUserId", "" + userReturned.userId);

        // cart
        let cartFound = false;
        this._cartService.Getcart().subscribe((carts: Cart[]) => {
          console.log("Carts: ", carts)
          for (var cart of carts) {
            if (cart.cartUserId === userReturned.userId && cart.purchasedCart === false) {
              cartFound = true;
            }
          }
          console.log("cartFound: ", cartFound)
          if (!cartFound) {
            // create user a new cart
            console.log("CART NOT FOUND ....")


            console.log("Current Date: ", formalDate)

            // let userInfo: Users =
            // {
            //   userId: userReturned.userId,
            //   lastName: userReturned.lastName,
            //   firstName: userReturned.firstName,
            //   address: userReturned.address,
            //   email: userReturned.email,
            //   cardNumber: userReturned.cardNumber,
            //   username: userReturned.username,
            //   password: userReturned.password

            // }
            console.log("USERINFO :", userReturned)
            if (!cartFound) {
              let newCart: CreateCart = {
                date: formalDate,
                purchasedCart: false,
                user: userReturned
              }

              console.log("new cart: ", newCart);
              this._cartService.Createcart(newCart);

              // need to route to main menu 

            }

          }


        }


        )


      }

    })

  }


}

