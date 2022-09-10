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
  constructor(private _UsersService: UsersService) { 
    this.users = _UsersService.
  }



  ngOnInit(): void {
    
  }

}

export class EmployeeNamesComponent {
    public employees:object =[];
    constructor(private _employeeService : EmployeeService){
            this.employees = _employeeService.getEmployees();
  }
}   