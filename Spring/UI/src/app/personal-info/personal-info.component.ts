import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Users } from '../user';
import { UsersService } from '../users.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-personal-info',
  templateUrl: './personal-info.component.html',
  styleUrls: ['./personal-info.component.css']
})
export class PersonalInfoComponent implements OnInit {
  // router: Router;

  _userService: UsersService;
  user: Users = {id: 0,
    firstName: "",
    lastName: "",
    email: "",
    password: "",
    username: "",
    address: "",
    cardNumber: 0} ;

    router: ActivatedRoute;



  constructor(private http: HttpClient, userService: UsersService, router: ActivatedRoute) {
    this._userService = userService;
    this.router = router;
   }

  ngOnInit(): void {
    let id = parseInt(this.router.snapshot.paramMap.get('id')!, 10);

    this.getCurrentUser(id);

    this.displayProfileInfo()
  }
  
  getCurrentUser(id: number): void{
      this._userService.GetUserbyId(id)
      .subscribe(data => 
        {
          this.user = data;
        })
    }


  displayProfileInfo() {
    
  }
  //create self invoking fuction that makes a getUserById and then assignes each element to its parameter
    //userId
    //first name
    //last name
    //email
    //password
    //username
    //address
    //card number

    
    

    
    //create one-way data binding that will put each of these into the DOM
        //exept for card number, password, and userID will not be displayed... yet


  //profile info navigator
  profileInfo(): void {
    // //TODO: get profileInfo component
    // const navigationDestination: string[] = ['/profileInfo'];
    // this.router.navigate(navigationDestination, {replaceUrl:true});
  }

//cart navigator
cart(): void {
    // //TODO: get profileInfo component
    // const navigationDestination: string[] = ['/cart'];
    // this.router.navigate(navigationDestination, {replaceUrl:true});
}

  // reset password navigator
  resetPass(): void {
    // //TODO: make resetPass component
    // const navigationDestination: string[] = ['/resetPass'];
    // this.router.navigate(navigationDestination, {replaceUrl:true});
  }

  // updateAdd navigator
  updateAdd(): void {
    // //TODO: make changeEmail component
    // const navigationDestination: string[] = ['/updateAdd'];
    // this.router.navigate(navigationDestination, {replaceUrl:true});
  }

  //changeEmail
  changeEmail(): void {
    //TODO: make changeEmail component
    // const navigationDestination: string[] = ['/changeEmail'];
    // this.router.navigate(navigationDestination, {replaceUrl:true});
  }

  //view payInfo
  payInfo(): void {
    //TODO: make payInfo component
    // const navigationDestination: string[] = ['/payInfo'];
    // this.router.navigate(navigationDestination, {replaceUrl:true});
  }

  //return to home page
      //whatever the main page after log in is
        //do not have atm
  home(): void {
    //TODO: get home component
    // const navigationDestination: string[] = ['/home'];
    // this.router.navigate(navigationDestination, {replaceUrl:true});
  }
}
