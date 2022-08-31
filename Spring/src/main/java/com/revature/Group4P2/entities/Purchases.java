package com.revature.Group4P2.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;


@Entity(name = "purchases")
public class Purchases {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private Integer purchaseId;

    @Column(name = "item_id")
    private Integer itemId;

    @Column
    private String date;

    @Column(name = "quantity_purchased")
    private Double quantityPurchased;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "user_id")
    private Integer userId;

    // foreign key objects
    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "item_id") // not sure if needed still
    @JsonBackReference
    private Catalog catalog;

    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
    @JsonBackReference
    private Users user;

    // constructors

    public Purchases() {
    }

    public Purchases(Integer purchaseId, Integer itemId, String date, Double quantityPurchased, Double totalAmount, Integer userId, Catalog catalog, Users user) {
        this.purchaseId = purchaseId;
        this.itemId = itemId;
        this.date = date;
        this.quantityPurchased = quantityPurchased;
        this.totalAmount = totalAmount;
        this.userId = userId;
        this.catalog = catalog;
        this.user = user;
    }

    public Purchases( Integer itemId, String date, Double quantityPurchased, Double totalAmount, Integer userId, Catalog catalog, Users user) {
        this.itemId = itemId;
        this.date = date;
        this.quantityPurchased = quantityPurchased;
        this.totalAmount = totalAmount;
        this.userId = userId;
        this.catalog = catalog;
        this.user = user;
    }


    // getters and setters


    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getQuantityPurchased() {
        return quantityPurchased;
    }

    public void setQuantityPurchased(Double quantityPurchased) {
        this.quantityPurchased = quantityPurchased;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Purchases{" +
                "purchaseId=" + purchaseId +
                ", itemId=" + itemId +
                ", date='" + date + '\'' +
                ", quantityPurchased=" + quantityPurchased +
                ", totalAmount=" + totalAmount +
                ", userId=" + userId +
                ", catalog=" + catalog +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchases purchases = (Purchases) o;
        return Objects.equals(purchaseId, purchases.purchaseId) && Objects.equals(itemId, purchases.itemId) && Objects.equals(date, purchases.date) && Objects.equals(quantityPurchased, purchases.quantityPurchased) && Objects.equals(totalAmount, purchases.totalAmount) && Objects.equals(userId, purchases.userId) && Objects.equals(catalog, purchases.catalog) && Objects.equals(user, purchases.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseId, itemId, date, quantityPurchased, totalAmount, userId, catalog, user);
    }
}
