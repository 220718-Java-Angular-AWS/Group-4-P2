package com.revature.Group4P2.beans.controllers;

import com.revature.Group4P2.beans.services.CartService;
import com.revature.Group4P2.entities.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/cart")
public class CartControllers {
    private CartService service;


    @Autowired
    public CartControllers(CartService service) {
        this.service = service;
    }

    //5 crud things:
    // GET - read by id- find,
    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody Cart getCartById(@PathVariable Integer cartId)
    {
        Optional<Cart> optionalCart = service.getCartById(cartId);
        return optionalCart.get();
    }

    // GET - read all - find all,
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<Cart> getAllCart()
    {
        return service.getAllCart();
    }
    // POST - create - save,
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void createCart(@RequestBody Cart cart)
    {
        service.createCart(cart);
    }


    // PUT/PATCH - update - save,
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void updateCart(@RequestBody Cart cart)
    {
        service.updateCart(cart);
    }
    // DELETE - delete - delete
    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteCart(@PathVariable Integer cartId)
    {
        service.deleteCartById(cartId);
    }

}
