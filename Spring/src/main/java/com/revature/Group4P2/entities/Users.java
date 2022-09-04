package com.revature.Group4P2.entities;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "shopping_user")
public class Users {
    // columns and variables
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String username;

    @Column
    private String address;

    @Column(name = "card_number")
    private String cardNumber;


    // WHEN THESE ARE COMMENTED OUT IT WILL POST
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) // name of the shoppinguser object in purchase class
    @JsonManagedReference(value = "user-purchases")
    private List<Purchases> purchases ;
//
    // foreign key for cart

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "user-cart")
    private List<Cart> cart ;

    // constructors


    public Users() {
    }

    public Users(Integer id, String firstName, String lastName, String email, String password, String username, String address, String cardNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.username = username;
        this.address = address;
        this.cardNumber = cardNumber;
    }
    public Users( String firstName, String lastName, String email, String password, String username, String address, String cardNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.username = username;
        this.address = address;
        this.cardNumber = cardNumber;

    }

    // getters and setters

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

    public List<Purchases> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchases> purchases) {
        this.purchases = purchases;
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(id, users.id) && Objects.equals(firstName, users.firstName) && Objects.equals(lastName, users.lastName) && Objects.equals(email, users.email) && Objects.equals(password, users.password) && Objects.equals(username, users.username) && Objects.equals(address, users.address) && Objects.equals(cardNumber, users.cardNumber) && Objects.equals(purchases, users.purchases) && Objects.equals(cart, users.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password, username, address, cardNumber, purchases, cart);
    }
}
