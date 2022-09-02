package com.revature.Group4P2.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "cart")
public class Cart {
    // columns and attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Integer itemId;

    @Column
    private Integer quantity;


    // foreign key for item_id which is from catalog
    @ManyToOne( cascade = CascadeType.ALL)
    @JsonBackReference(value = "catalog-cart")
    private Catalog catalog;

    // foreign key userID which is from ShoppingUser
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference(value = "user-cart")
    private Users user;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "purchase-cart")
    private List<Purchases> purchasesList;


    // constructors
    public Cart() {
    }

    public Cart(Integer itemId, Integer quantity, Catalog catalog, Users user) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.catalog = catalog;
        this.user = user;
    }

    public Cart( Integer quantity, Catalog catalog, Users user) {
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

    public List<Purchases> getPurchasesList() {
        return purchasesList;
    }

    public void setPurchasesList(List<Purchases> purchasesList) {
        this.purchasesList = purchasesList;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "itemId=" + itemId +
                ", quantity=" + quantity +
                ", catalog=" + catalog +
                ", user=" + user +
                ", purchasesList=" + purchasesList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(itemId, cart.itemId) && Objects.equals(quantity, cart.quantity) && Objects.equals(catalog, cart.catalog) && Objects.equals(user, cart.user) && Objects.equals(purchasesList, cart.purchasesList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, quantity, catalog, user, purchasesList);
    }

}
