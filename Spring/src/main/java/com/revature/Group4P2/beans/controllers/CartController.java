package com.revature.Group4P2.beans.controllers;

import com.revature.Group4P2.beans.services.CartService;
import com.revature.Group4P2.beans.services.CatalogService;
import com.revature.Group4P2.beans.services.UserService;
import com.revature.Group4P2.entities.*;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

    private CartService service;

    // catalog and user services
    private CatalogService catalogService;
    private UserService userService;

    @Autowired
    public CartController(CartService service, CatalogService catalogService, UserService userService) {
        System.out.println("IN CART CONTROLLER");
        this.service = service;
        this.catalogService = catalogService;
        this.userService = userService;
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody Cart getCartById(@PathVariable Integer cartId)
    {
        Optional<Cart> optionalCart = service.getCartById(cartId);
        optionalCart.get().setCartUserId(optionalCart.get().getUser().getUserId());
        return optionalCart.get();
    }

    @RequestMapping(value = "getAllCartById/{getAllCartById}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<Cart> getAllCartByUserId(@PathVariable Integer getAllCartById)
    {
        List<Cart> cart = service.getAllCartById(getAllCartById);
        return cart;
    }

    //getCartByUserIdPurchaseIsFalse
    @RequestMapping(value = "getCartByUserIdPurchaseIsFalse/{getCartById}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody Cart getCartByUserIdPurchaseIsFalse(@PathVariable Integer getCartById)
    {
        Optional<Cart> optionalCart = service.getCartByUserIdPurchaseIsFalse(getCartById);
        return optionalCart.get();
    }


    // GET - read all - find all,
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<Cart> getAllCart()
    {
        System.out.println("MADE INTO CART ");
        List<Cart> allCart = service.getAllCart();
        for(int i =0; i < allCart.size(); i++)
        {
          allCart.get(i).setCartUserId(allCart.get(i).getUser().getUserId());
        }
        return service.getAllCart();
    }

    // POST - create - save,
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void createCart(@RequestBody Cart cart)
    {
        System.out.println("MADE INTO CART CREATE");
        Optional<Users> optionalUsers = userService.getUserById(cart.getUser().getUserId());

        if(optionalUsers.isPresent()) {
            Users user = userService.getUserById(cart.getUser().getUserId()).get();
            cart.setUser(user);
            cart.setCartUserId(user.getUserId());
            service.createCart(cart);
        }
        else
        {
            // throw exception later on
            System.out.println("CART ITEM NOT CREATED");
        }

    }


    // PUT/PATCH - update - save,
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void updateCart(@RequestBody Cart cart)
    {
        Optional<Users> optionalUsers = userService.getUserById(cart.getUser().getUserId());

        if(optionalUsers.isPresent()) {
            cart.setUser(userService.getUserById(cart.getUser().getUserId()).get());
            service.updateCart(cart);
        }
        else
        {
            // throw exception later on
            System.out.println("CART ITEM NOT UPDATED");
        }
    }
    // DELETE - delete - delete
    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteCart(@PathVariable Integer cartId)
    {
        Optional<Cart> optionalCart = service.getCartById(cartId);
        if(optionalCart.isPresent())
        {
            Cart cart = optionalCart.get();
            cart.setUser(null);
            service.updateCart(cart);
            service.deleteCartById(cartId);
        }

    }


}
