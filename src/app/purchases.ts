import { Users } from "./users";
import { Catalog } from "./catalog";

export interface Purchases {
    purchaseId: number;
    date: String;
    quantityPurchased: number;
    totalAmount: number;
    catalog: Catalog;
    user: Users;
}
