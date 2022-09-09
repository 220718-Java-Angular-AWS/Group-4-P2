import { catalogDetails } from "./catalogDetails";
export interface Catalog {
    itemId: number;
    itemName: String;
    itemPrice: number;
    catalogDetails: catalogDetails;
}
