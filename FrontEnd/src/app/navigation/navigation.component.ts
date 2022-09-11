import { Component, OnInit } from '@angular/core';
import { Users } from "../users";
import { UsersService } from '../users.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {
public  users:object = [];


  ngOnInit(): void {
    
  }
}

   