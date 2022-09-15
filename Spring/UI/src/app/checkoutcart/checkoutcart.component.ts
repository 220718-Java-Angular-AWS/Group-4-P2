import { Component, Input, OnInit } from '@angular/core';
import { Cart } from '../cart';
import { CartService } from '../cart.service';
import { CartItems } from '../cart-items';
import { CartItemService } from '../cart-item.service';
import { Users } from '../user';
import { UsersService } from '../users.service';
import { CatalogService } from '../catalog.service';
import { Catalog } from '../catalog';
import { Router } from '@angular/router';

@Component({
  selector: 'app-checkoutcart',
  templateUrl: './checkoutcart.component.html',
  styleUrls: ['./checkoutcart.component.css']
})
export class CheckoutcartComponent implements OnInit {
  _cartService: any;
  //how do i grab the current instance of userId + what cart is false? 
  _cartItemsService: CartItemService;
  _catalogService: CatalogService;
  currentUserId: number = 0;
  cartCatalogItems: [Catalog, number][] = [];
  totalCost: number = 0;
  confirmationCheckout: string = "";
  userCart: Cart =
    {
      cartId: 0,
      date: "",
      purchasedCart: false,
      cartUserId: 0

    }

  userCartItems: CartItems[] = [];


  router: Router;




  constructor(cartService: CartService, cartItemService: CartItemService, catalogService: CatalogService, router: Router) {
    this._cartService = cartService;
    this._cartItemsService = cartItemService;
    this._catalogService = catalogService;
    this.router = router;
  }

  ngOnInit(): void {

  }
 
  

  viewCartItems() { //should somehow detect userId and load upon routing here?
    this._cartService.GetCartByIdFalseCart(this.currentUserId)
      .subscribe((cart: Cart) => {
        console.log("CHECKOUT VIEW CART : ", cart);
        this.userCart = cart;
        console.log("cart Cart ID:", cart.cartId)
        // need to get all the cart items associated with this cart 
        this._cartItemsService.GetAllCartItemsByCartId(cart.cartId)
          .subscribe((cartItems: CartItems[]) => {
            this.userCartItems = cartItems;
            // need to get all the items from catalog to display 
            for (var item of cartItems) {

              //cartCatalogItems
              this._catalogService.GetcatalogbyId(item.catalogId)
                .subscribe((catItem: Catalog) => {
                  this.totalCost += item.totalCost;
                  this.cartCatalogItems.push([catItem, item.totalCost])
                })
            }
          })

      });
  }

  buyCart() {

    // need to set the cart to true 

    // find a way to fake charge card maybe ??
    this.confirmationCheckout = "Thank you for making a purchase";
    //need to set the cart to true 
    this.userCart.purchasedCart = true;
    this._cartService.Updatecart(this.userCart)
      .subscribe(
        () => {
          console.log("UPDATED CART SHOULD NOW BE TRUE FOR " + this.userCart.cartId);
        }
      )
  }

  cartId(cartId: any) {
    throw new Error('Method not implemented.');
  }

  deleteItem(id: number): void {
    console.log('cartItemId DELETE CATALOG: ', id)

    for (var cartItem of this.userCartItems) {

      if (cartItem.catalogId === id) {
        console.log("MADE INTO IF STATEMENT DELETE ")
        console.log("CART ITEM CATALOG ID :  ", cartItem.catalogId);
        console.log("CART ITEM ID: ", cartItem.cartItemId);

        this._cartItemsService.DeleteCartItems(cartItem.cartItemId)
          .subscribe(() => {
            console.log("Deleted Cart Item Id: " + cartItem.cartItemId)
            // this.router.navigate(['/checkoutcart'], { replaceUrl: true })
            // clear screen 

          })

        // this.router.navigate(['/checkoutcart'], { replaceUrl: true })
      }
    }



  }

}