package com.revature.Group4P2.beans.controllers;

import com.revature.Group4P2.beans.services.CartService;
import com.revature.Group4P2.entities.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//TOTALLY UNSURE OF THIS CONTROLLER IN GENERAL -- SHOULD WE PASS AN ITEM ID OR THE USER ID?

@Controller
@RequestMapping(value = "/cart")
public class CartController {

    private CartService service;

    @Autowired
    public CartController(CartService cartService) {
        this.service = cartService;
    }

    @RequestMapping(value = "/{userID}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody Cart getCatalogById(@PathVariable Integer userID) {
        Optional<Cart> optionalCart = service.getCartById(userID);
        return optionalCart.get();
    }

    //If we are using the userId, I am not sure what function this will serve in the project

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<Cart> getAllCarts() {
        return service.getAllCarts();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void createCart(@RequestBody Cart cart) {
        service.createCart(cart);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void updateCart(@RequestBody Cart cart) {
        service.updateCart(cart);
    }

    @RequestMapping(value = "/{userID}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteCart(@PathVariable(name = "userID") Integer id) {
        service.deleteCart(id);
    }
}

