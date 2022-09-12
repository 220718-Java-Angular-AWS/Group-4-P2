import { Users } from "./user";
export interface Cart {
    cartId: number;
    date: String;
    purchasedCart: boolean;
    Users: Users;
}