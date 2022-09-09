import { Catalog } from "./catalog";
import { Users } from "./users";

export interface Cart {
    itemId: number;
    quantity: number;
    catalog: Catalog;
    user: Users;
}
