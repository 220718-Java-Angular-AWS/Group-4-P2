package com.revature.Group4P2.DTOS;

public class principal {
    private String email;
    private String password;

    public principal(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public principal() {
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

}
