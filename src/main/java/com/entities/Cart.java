package com.entities;

import com.entities.ShoppingUser;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {

    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "user_id")
    private Integer userID;

    @Column
    private Integer quantity;



    // foreign key for item_id which is from catalog
    @ManyToOne
    @JoinColumn(name = "itemId", nullable = false)
    private Catalog catalog;

    // foreign key userID which is from ShoppingUser
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private ShoppingUser user;


    // constructors
    public Cart() {
    }

    public Cart(Integer itemId, Integer userID, Integer quantity, Catalog catalog, ShoppingUser user) {
        this.catalog = catalog;
        this.user = user;
        this.itemId = catalog.getItemId();
        this.userID = user.getId();
        this.quantity = quantity;

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

    public ShoppingUser getUser() {
        return user;
    }

    public void setUser(ShoppingUser user) {
        this.user = user;
    }
}
