package com.revature.Group4P2.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;


@Entity(name = "purchases")
public class Purchases {

    // columns and variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private Integer purchaseId;

    @Column
    private String date;

    @Column(name = "quantity_purchased")
    private Integer quantityPurchased; // this is something from cart

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column
    private String size;

    // foreign key objects
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference(value = "purchase-cart")
    private Cart cart;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference(value = "purchase-catalog")
    private Catalog catalog;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference(value = "user-purchases")
    private Users user;

    // constructors

    public Purchases() {
    }

    public Purchases(Integer purchaseId, String date, Integer quantityPurchased, Double totalAmount, Catalog catalog, Users user, Cart cart) {
        this.purchaseId = purchaseId;
        this.date = date;
        this.quantityPurchased = quantityPurchased;
        this.totalAmount = totalAmount;
        this.catalog = catalog;
        this.user = user;
        this.cart = cart;
        this.size = size;
    }

    public Purchases( String date, Integer quantityPurchased, Double totalAmount, Catalog catalog, Users user, Cart cart) {
        this.date = date;
        this.quantityPurchased = quantityPurchased;
        this.totalAmount = totalAmount;
        this.catalog = catalog;
        this.user = user;
        this.cart = cart;
        this.size = size;
    }


    // getters and setters


    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getQuantityPurchased() {
        return quantityPurchased;
    }

    public void setQuantityPurchased(Integer quantityPurchased) {
        this.quantityPurchased = quantityPurchased;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Purchases{" +
                "purchaseId=" + purchaseId +
                ", date='" + date + '\'' +
                ", quantityPurchased=" + quantityPurchased +
                ", totalAmount=" + totalAmount +
                ", cart=" + cart +
                ", catalog=" + catalog +
                ", user=" + user +
                ", size=" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchases purchases = (Purchases) o;
        return Objects.equals(purchaseId, purchases.purchaseId) && Objects.equals(date, purchases.date) && Objects.equals(quantityPurchased, purchases.quantityPurchased) && Objects.equals(totalAmount, purchases.totalAmount) && Objects.equals(size, purchases.size) && Objects.equals(cart, purchases.cart) && Objects.equals(catalog, purchases.catalog) && Objects.equals(user, purchases.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseId, date, quantityPurchased, totalAmount, size, cart, catalog, user);
    }
}
