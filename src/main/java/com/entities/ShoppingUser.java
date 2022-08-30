package com.entities;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "shopping_user")
public class ShoppingUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String username;

    @Column
    private String address;

    @Column(name = "card_number")
    private String cardNumber;

    // foreign keys in other tables
    // foreign key for Purchases
    @OneToMany(mappedBy = "user") // name of the shoppinguser object in purchase class
    private List<Purchases> purchasesList;

    // foreign key for cart
    @OneToMany(mappedBy = "user")
    private List<Cart> cartList;

    // constructors
    public ShoppingUser() {
    }

    public ShoppingUser(Integer id, String firstName, String lastName, String email, String password, String username, String address, String cardNumber, List<Purchases> purchasesList, List<Cart> cartList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.username = username;
        this.address = address;
        this.cardNumber = cardNumber;
        this.purchasesList = purchasesList;
        this.cartList = cartList;
    }
    public ShoppingUser(String firstName, String lastName, String email, String password, String username, String address, String cardNumber, List<Purchases> purchasesList, List<Cart> cartList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.username = username;
        this.address = address;
        this.cardNumber = cardNumber;
        this.purchasesList = purchasesList;
        this.cartList = cartList;
    }
    public ShoppingUser(Integer id, String firstName, String lastName, String email, String password, String username, String address, String cardNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.username = username;
        this.address = address;
        this.cardNumber = cardNumber;
        this.purchasesList = new LinkedList<>();
        this.cartList = new LinkedList<>();
    }
    public ShoppingUser(String firstName, String lastName, String email, String password, String username, String address, String cardNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.username = username;
        this.address = address;
        this.cardNumber = cardNumber;
        this.purchasesList = new LinkedList<>();
        this.cartList = new LinkedList<>();
    }

    public ShoppingUser(Integer id, String firstName, String lastName, String email, String password, String username, List<Purchases> purchasesList, List<Cart> cartList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.username = username;
        this.purchasesList = purchasesList;
        this.cartList = cartList;
    }
    public ShoppingUser(String firstName, String lastName, String email, String password, String username, List<Purchases> purchasesList, List<Cart> cartList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.username = username;
        this.purchasesList = purchasesList;
        this.cartList = cartList;
    }
    public ShoppingUser(Integer id, String firstName, String lastName, String email, String password, String username) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.username = username;
        this.purchasesList = new LinkedList<>();
        this.cartList = new LinkedList<>();
    }
    public ShoppingUser(String firstName, String lastName, String email, String password, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.username = username;
        this.purchasesList = new LinkedList<>();
        this.cartList = new LinkedList<>();
    }

    //getters and setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
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
