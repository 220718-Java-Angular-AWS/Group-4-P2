import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Cart } from '../cart';
import { CartItemService } from '../cart-item.service';
import { CartService } from '../cart.service';
import { Catalog } from '../catalog';
import { CatalogService } from '../catalog.service';
import { CreateCartItems } from '../create-cart-item';

@Component({
  selector: 'app-item-details',
  templateUrl: './item-details.component.html',
  styleUrls: ['./item-details.component.css']
})
export class ItemDetailsComponent implements OnInit {

  currentUserId : number = Number(localStorage.getItem("currentUserId"));

  

  _catalogService : CatalogService ;
  router: ActivatedRoute;
  _cartService: CartService;
  _cartItemService: CartItemService;

  srcImage : string = "";
  quantity: number = 0;
  purchaseAmount: number = 0;
  itemAddedToCart:string = "";

  catalogItem: Catalog = {
    itemId: 0,
    itemName: "",
    itemPrice: 0,
    catalogDetailsId: 0,
    imageURL:""
  };

  cart : Cart= {
    cartId: 0,
    date: '',
    purchasedCart: false,
    cartUserId: 0
  }

  constructor(catalogService : CatalogService, router: ActivatedRoute, cartService: CartService, cartitemservice: CartItemService) {
    this._catalogService = catalogService;
    this.router = router;
    this._cartService = cartService;
    this._cartItemService = cartitemservice;
   }

  ngOnInit(): void {
    this.getItem();

  }

  getItem(): void 
  {
    // get the id passed from the router 
    let id = parseInt(this.router.snapshot.paramMap.get('id')!, 10); 

    // find the item through catalogservice 
    this._catalogService.GetcatalogbyId(id)
    .subscribe((item: Catalog)=> {this.catalogItem = item;
    this.srcImage = this.catalogItem.imageURL});


    this._cartService.GetCartByIdFalseCart(this.currentUserId)
    .subscribe((data: Cart) => {this.cart = data})

    


  }


  changeQuantity(): void {
    if(this.catalogItem !== undefined)
    {
      this.purchaseAmount = this.quantity * this.catalogItem.itemPrice;
    }
  }

  addItemToCart(): void
  {
    // need to add the item to the cart 
    let createItem : CreateCartItems ;
    

    // createCart
    createItem = {
      quantity: this.quantity,
      totalCost: this.purchaseAmount,
      catalog: this.catalogItem,
      Cart: this.cart 
    } 

    

    this._cartItemService.createCartItem(createItem)

    // add item to screen 
    this.itemAddedToCart = "Amount of $"+ this.purchaseAmount + " was added to your cart";

  }


}
