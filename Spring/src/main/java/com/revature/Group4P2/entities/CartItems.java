package com.revature.Group4P2.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.security.PrivateKey;

@Entity(name = "cart_items")
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Integer cartItemId;

    @Column
    private Integer quantity;


    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference(value = "catalog-cartitem")
    private Catalog catalog;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference(value = "cart-cartitem")
    private Cart cart;

    @Transient
    private Integer catalogId;

    public CartItems() {
    }

    public CartItems(Integer cartItemId, Integer quantity, Catalog catalog, Cart cart) {
        this.cartItemId = cartItemId;
        this.quantity = quantity;
        this.catalog = catalog;
        this.cart = cart;
    }

    public CartItems(Integer quantity, Catalog catalog, Cart cart) {
        this.quantity = quantity;
        this.catalog = catalog;
        this.cart = cart;
    }

    public Integer getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Integer cartItemId) {
        this.cartItemId = cartItemId;
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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    @Override
    public String toString() {
        return "CartItems{" +
                "cartItemId=" + cartItemId +
                ", quantity=" + quantity +
                ", catalog=" + catalog +
                ", cart=" + cart +
                '}';
    }


}
