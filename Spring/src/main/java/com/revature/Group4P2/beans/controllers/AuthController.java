package com.revature.Group4P2.beans.controllers;
import com.revature.Group4P2.dto.Login;
import com.revature.Group4P2.beans.services.AuthService;
import com.revature.Group4P2.entities.Users;
import com.revature.Group4P2.exceptions.AccessDeniedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(value = "/login")
public class AuthController {
    private AuthService service;

    @Autowired
    public AuthController(AuthService authService) {
        this.service = authService;
    }


    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Users authenticate(@RequestBody Login login) throws AccessDeniedException {
        System.out.println("Made into athenticate");
        return service.authenticate(login.getUsername(), login.getPassword());
    }

}