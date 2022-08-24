package com.entities;

import com.entities.ShoppingUser;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "cart")
public class Cart {

    @Column(name = "item_id")
    private Integer id;
    @Column(name = "user_id")
    private Integer userID;
    @Column
    private Integer quantity;

    // need shopping user object to create foreign key
    @ManyToOne
    @JoinColumn(name = "user_id")
    private ShoppingUser user;

    public Cart() {
    }

    public Cart(Integer id, Integer userID, Integer quantity, ShoppingUser user) {
        this.id = id;
        this.userID = userID;
        this.quantity = quantity;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public ShoppingUser getUser() {
        return user;
    }

    public void setUser(ShoppingUser user) {
        this.user = user;
    }
}
