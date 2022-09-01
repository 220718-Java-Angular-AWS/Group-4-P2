package com.revature.Group4P2.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "catalog")
public class Catalog {

    //When I pulled from gitHub the ID annotation was missing here
    @Id
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "catalog_details_group", nullable = false)
    @JsonBackReference
    private CatalogDetails catalogDetails;


    public Catalog() {
    }

    public Catalog(Integer itemId, String itemName, Double itemPrice, String catalogGroup, CatalogDetails catalogDetails) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.catalogGroup = catalogGroup;
        this.catalogDetails = catalogDetails;
    }
    public Catalog( String itemName, Double itemPrice, String catalogGroup, CatalogDetails catalogDetails) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.catalogGroup = catalogGroup;
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

    @Override
    public String toString() {
        return "Catalog{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", catalogGroup='" + catalogGroup + '\'' +
                ", catalogDetails=" + catalogDetails +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catalog catalog = (Catalog) o;
        return Objects.equals(itemId, catalog.itemId) && Objects.equals(itemName, catalog.itemName) && Objects.equals(itemPrice, catalog.itemPrice) && Objects.equals(catalogGroup, catalog.catalogGroup) && Objects.equals(catalogDetails, catalog.catalogDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, itemName, itemPrice, catalogGroup, catalogDetails);
    }


}


