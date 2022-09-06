package com.revature.Group4P2.beans.controllers;
import com.revature.Group4P2.DTOS.Login;
import com.revature.Group4P2.beans.services.AuthService;
import com.revature.Group4P2.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class AuthController {
    private AuthService service;

    @Autowired
    public AuthController(AuthService authService) {
        this.service = authService;
    }


    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public Users authenticate(@RequestBody Login login) throws com.revature.Group4P2.exceptions.AccessDeniedException {
        return service.authenticate(login.getUsername(), login.getPassword());
    }

}
