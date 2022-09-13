import { Component, OnInit } from '@angular/core';
import { SearchBarService } from '../search-bar/search-bar.service';

@Component({
  selector: 'app-catalog-display',
  templateUrl: './catalog-display.component.html',
  styleUrls: ['./catalog-display.component.css']
})
export class CatalogDisplayComponent implements OnInit {

  constructor(public searchBarService: SearchBarService) { }

  ngOnInit(): void {
  }

}
