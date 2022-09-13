import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SearchBarService {

  result: any;
  constructor() {
    this.result = [
      {
        name: 'shoes',
        itemId: 1
      },
      {
        name: 'shirts'
        
      },
      {
        name:'pants'

      },
      {
        name: 'hats'
      },
      {
        name: 'sneakers',
        img: "url",
        itemId: 1
      },
      {
        name: 'shoe2'
      },
      {
        name: 'shoe3'
      },
      {
        name: 'shoe4'
      },
    ]
   }
}
