package com.revature.Group4P2.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "catalog")
public class Catalog {
    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_price")
    private Double itemPrice;

//    private Integer Inventory;

//    @Column(name = "catalog_group")
//    private String catalogGroup;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference(value = "catalogDetails - catalog")
    private CatalogDetails catalogDetails;

    @OneToMany(mappedBy = "catalog", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "catalog-cart")
    private List<Cart> cartList;

    @OneToMany(mappedBy = "catalog", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "purchase-catalog")
    private List<Purchases> purchaseList;

    public Catalog() {
    }

    public Catalog(Integer itemId, String itemName, Double itemPrice, CatalogDetails catalogDetails) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
//        this.catalogGroup = catalogGroup;
        this.catalogDetails = catalogDetails;
    }
    public Catalog( String itemName, Double itemPrice, CatalogDetails catalogDetails) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
//        this.catalogGroup = catalogGroup;
        this.catalogDetails = catalogDetails;
    }

    // getters and setters


    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

//    public String getCatalogGroup() {
//        return catalogGroup;
//    }
//
//    public void setCatalogGroup(String catalogGroup) {
//        this.catalogGroup = catalogGroup;
//    }

    public CatalogDetails getCatalogDetails() {
        return catalogDetails;
    }

    public void setCatalogDetails(CatalogDetails catalogDetails) {
        this.catalogDetails = catalogDetails;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }

    public List<Purchases> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Purchases> purchaseList) {
        this.purchaseList = purchaseList;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
//                ", catalogGroup='" + catalogGroup + '\'' +
                ", catalogDetails=" + catalogDetails +
                ", cartList=" + cartList +
                ", purchaseList=" + purchaseList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catalog catalog = (Catalog) o;
        return Objects.equals(itemId, catalog.itemId) && Objects.equals(itemName, catalog.itemName) && Objects.equals(itemPrice, catalog.itemPrice) && Objects.equals(catalogDetails, catalog.catalogDetails) && Objects.equals(cartList, catalog.cartList) && Objects.equals(purchaseList, catalog.purchaseList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, itemName, itemPrice, catalogDetails, cartList, purchaseList);
    }
}


