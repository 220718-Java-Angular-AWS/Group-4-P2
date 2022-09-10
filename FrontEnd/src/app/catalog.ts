import { CatalogDetails } from "./catalogDetails";

export interface Catalog {
    itemId: number;
    itenName: String;
    itemPrice: number;
    catalogDetails: CatalogDetails;
}
