import { Component, OnInit } from '@angular/core';
import { CreateUsers } from '../createUser';
import { UsersService } from '../users.service';
import { Route, Router } from '@angular/router';


@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent{

  service: UsersService;
  router: Router;
  constructor(userService: UsersService, router:Router) {
    this.service = userService;
    this.router = router;
  }

  ngOnInit(): void {
  }

  firstName: string = "";
  lastName: string = "";
  userName: string = "";
  email: string = "";
  password: string = "";
  address: string = "";
  cardNumber: string = "";
  
  

  onSignUp(): void
  {
    // needs to get the information from template and 
    // try to create a new user in the database 

    // for navigation help: https://stackoverflow.com/questions/47010159/how-to-redirect-to-a-new-page-in-angular-4-through-button-click
    const navigationDestination: string[] = ['/login'];
    
    // create new User Object
    let newUser: CreateUsers = 
    {
      firstName: this.firstName,
      lastName: this.lastName,
      username:this.lastName,
      email:this.email,
      password:this.password,
      address:this.address,
      cardNumber:this.cardNumber
    };

    // then need to post new User 
    this.service.CreateUser(newUser)
    .subscribe(data =>{
      console.log("Post Request for creating new employee");
      console.log("New User:" + newUser.address)
  });


  this.router.navigate(navigationDestination, {replaceUrl:true});
  } // end of onsubmit
  

}
