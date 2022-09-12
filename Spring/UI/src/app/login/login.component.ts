import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from '../login';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  _service: LoginService;
  _router: Router;

  userName: string = "";
  password: string = "";
  

  constructor(service: LoginService, router:Router) {
    this._service = service;
    this._router = router;


   }

  ngOnInit(): void {
  }

  onLogin(): void
  {
    // need to create a login reference and then use login service and see what it returns 
    // if successful then should move onto main menu if not then display that 
    let loginReturn: boolean = true;
    let loginCredintials: Login = 
    {
      username: this.userName,
      password: this.password
    };

    
    this._service.Login1(loginCredintials)
    .subscribe(login =>{ 
      if( login === null || login === undefined) 
      {
        loginReturn = false;
      }});

    if(loginReturn)
    {
      // then login to main menu 
      console.log("Login Status: " + loginReturn);

    }

    else
    {
      // login failed 
      console.log("Login Status: " + loginReturn);
    }


    // need to use service 


  }


}
