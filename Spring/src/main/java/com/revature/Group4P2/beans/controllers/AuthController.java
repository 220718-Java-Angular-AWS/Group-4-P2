package com.revature.Group4P2.beans.controllers;

import com.revature.Group4P2.beans.Exceptions.AccessDeniedException;
import com.revature.Group4P2.beans.services.AuthService;
import com.revature.Group4P2.dto.Principal;
import com.revature.Group4P2.entities.Users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class AuthController {
    private AuthService service;

    public AuthController(AuthService authService) {
        this.service = authService;
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public Users authenticate(@RequestBody Principal principal) throws AccessDeniedException {
        return service.authenticate(principal.getUsername(), principal.getPassword());
    }
}
