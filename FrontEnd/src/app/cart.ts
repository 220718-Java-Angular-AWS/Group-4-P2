import { Users } from "./users";
export interface Cart {
    cartId: number;
    date: String;
    purchasedCart: boolean;
    Users: Users;
}
