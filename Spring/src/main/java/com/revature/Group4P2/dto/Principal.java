package com.revature.Group4P2.dto;

public class Principal {
        private String username;
        private String password;

        public Principal(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public Principal() {

        }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
