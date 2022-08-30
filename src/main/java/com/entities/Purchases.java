package com.entities;



import javax.persistence.*;

@Entity
@Table(name = "purchases")
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
    @ManyToOne
    @JoinColumn(name = "itemId")
    private Catalog catalog;

    @ManyToOne
    @JoinColumn(name = "id")
    private ShoppingUser user;

    public Purchases() {
    }

    public Purchases(Integer purchaseId, Integer itemId, String date, Double quantityPurchased, Double totalAmount, Integer userId, Catalog catalog, ShoppingUser user) {
        this.purchaseId = purchaseId;
        this.catalog = catalog;
        this.user = user;
        this.itemId = catalog.getItemId();

        this.date = date;
        this.quantityPurchased = quantityPurchased;
        this.totalAmount = totalAmount;
        this.userId = user.getId();
    }

    public Purchases( Integer itemId, String date, Double quantityPurchased, Double totalAmount, Integer userId, Catalog catalog, ShoppingUser user) {
        this.catalog = catalog;
        this.user = user;
        this.itemId = catalog.getItemId();

        this.date = date;
        this.quantityPurchased = quantityPurchased;
        this.totalAmount = totalAmount;
        this.userId = user.getId();
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

    public ShoppingUser getUser() {
        return user;
    }

    public void setUser(ShoppingUser user) {
        this.user = user;
    }
}
