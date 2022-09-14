import { Component, OnInit } from '@angular/core';
import { Cart } from '../cart';
import { CartService } from '../cart.service';
import { CartItems } from '../cart-items';
import { CartItemService } from '../cart-item.service';
import { Users } from '../user';
import { UsersService } from '../users.service';

@Component({
  selector: 'app-checkoutcart',
  templateUrl: './checkoutcart.component.html',
  styleUrls: ['./checkoutcart.component.css']
})
export class CheckoutcartComponent implements OnInit {
  _CartService: any;
  _cart: Cart[] | undefined; //how do i grab the current instance of userId + what cart is false? 
  

  //requires  an *ngFor

  ngOnInit(): void {

  }
 
  viewCart() { //should somehow detect userId and load upon routing here?
    this._CartService.GetCartByIdFalseCart(this.cartId).subscribe((cart : Cart[]) => {
      this._cart = cart;
      console.log(this._cart)
    }); 
  }

  buyCart(){
//button that transforms false value to true on cart instance -should I use ngModel for this? 
  }
 
  cartId(cartId: any) {
    throw new Error('Method not implemented.');
  }

}
