import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { SearchBarService } from './search-bar.service';

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.css']
})
export class SearchBarComponent implements OnInit {

  constructor(public http: HttpClient, public searchBarService: SearchBarService) { }

  ngOnInit(): void {
  }
  baseurl = 'http://localhost:8080/catalog/itemName/'; // Needs correct URL
  searchInput: FormControl= new FormControl(null);
  
 
  search(){
     let keyword: any = this.searchInput.value;
     console.log(`${this.baseurl}${keyword}`);
     this.http.get(`${this.baseurl}${keyword}`).subscribe((res:any) => {
      console.log(res);
      this.searchBarService.result = res;
     })
  }

}
