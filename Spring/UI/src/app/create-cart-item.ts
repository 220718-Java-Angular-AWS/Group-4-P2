import { Cart } from "./cart";
import { Catalog } from "./catalog";

export interface CreateCartItems {
    quantity: number;
    catalog: Catalog;
    Cart: Cart;
}