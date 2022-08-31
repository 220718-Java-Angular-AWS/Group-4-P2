package com.revature.Group4P2.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "cart")
public class Cart {
    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "user_id")
    private Integer userID;

    @Column
    private Integer quantity;



    // foreign key for item_id which is from catalog
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
//    @JoinColumn(name = "item_id", nullable = false)
    private Catalog catalog;

    // foreign key userID which is from ShoppingUser
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
//    @JoinColumn(name = "user_id", nullable = false)
    private Users user;


    // constructors
    public Cart() {
    }

    public Cart(Integer itemId, Integer userID, Integer quantity, Catalog catalog, Users user) {
        this.itemId = itemId;
        this.userID = userID;
        this.quantity = quantity;
        this.catalog = catalog;
        this.user = user;
    }

    public Cart( Integer userID, Integer quantity, Catalog catalog, Users user) {
        this.userID = userID;
        this.quantity = quantity;
        this.catalog = catalog;
        this.user = user;
    }

    // getters and setters


    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
        return "Cart{" +
                "itemId=" + itemId +
                ", userID=" + userID +
                ", quantity=" + quantity +
                ", catalog=" + catalog +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(itemId, cart.itemId) && Objects.equals(userID, cart.userID) && Objects.equals(quantity, cart.quantity) && Objects.equals(catalog, cart.catalog) && Objects.equals(user, cart.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, userID, quantity, catalog, user);
    }
}
