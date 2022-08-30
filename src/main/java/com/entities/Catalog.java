package com.entities;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "catalog")
public class Catalog {

    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_price")
    private Double itemPrice;

//    private Integer Inventory;

    @Column(name = "catalog_group")
    private String catalogGroup;


    // foreign keys

    // foreign key catalogGroup references from catalodDetails table

    @ManyToOne
    @JoinColumn(name = "catalogDetailsGroup", nullable = false)
    private CatalogDetails catalogDetails;


    @OneToMany(mappedBy = "catalog")
    List<Purchases> purchasesList;

    @OneToMany(mappedBy = "catalog")
    List<Cart> cartList;


    // constructors
    public Catalog() {
    }

    public Catalog(Integer itemId, String itemName, Double itemPrice, String catalogGroup, CatalogDetails catalogDetails, List<Purchases> purchasesList, List<Cart> cartList) {
        this.itemId = itemId;
        this.catalogDetails = catalogDetails;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.catalogGroup = catalogDetails.getCatalogDetailsGroup();
        this.purchasesList = purchasesList;
        this.cartList = cartList;
    }

    public Catalog( String itemName, Double itemPrice, String catalogGroup, CatalogDetails catalogDetails, List<Purchases> purchasesList, List<Cart> cartList) {
        this.catalogDetails = catalogDetails;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.catalogGroup = catalogDetails.getCatalogDetailsGroup();
        this.purchasesList = purchasesList;
        this.cartList = cartList;
    }
    public Catalog(Integer itemId, String itemName, Double itemPrice, String catalogGroup, CatalogDetails catalogDetails) {
        this.itemId = itemId;
        this.catalogDetails = catalogDetails;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.catalogGroup = catalogDetails.getCatalogDetailsGroup();
        this.purchasesList = new LinkedList<>();
        this.cartList = new LinkedList<>();
    }
    public Catalog( String itemName, Double itemPrice, String catalogGroup, CatalogDetails catalogDetails) {
        this.catalogDetails = catalogDetails;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.catalogGroup = catalogDetails.getCatalogDetailsGroup();
        this.purchasesList = new LinkedList<>();
        this.cartList = new LinkedList<>();
    }

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

    public String getCatalogGroup() {
        return catalogGroup;
    }

    public void setCatalogGroup(String catalogGroup) {
        this.catalogGroup = catalogGroup;
    }

    public CatalogDetails getCatalogDetails() {
        return catalogDetails;
    }

    public void setCatalogDetails(CatalogDetails catalogDetails) {
        this.catalogDetails = catalogDetails;
    }

    public List<Purchases> getPurchasesList() {
        return purchasesList;
    }

    public void setPurchasesList(List<Purchases> purchasesList) {
        this.purchasesList = purchasesList;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }
}
