package com.revature.Group4P2.beans.controllers;

import com.revature.Group4P2.beans.services.CartService;
import com.revature.Group4P2.beans.services.CatalogService;
import com.revature.Group4P2.beans.services.UserService;
import com.revature.Group4P2.entities.Cart;
import com.revature.Group4P2.entities.Catalog;
import com.revature.Group4P2.entities.CatalogDetails;
import com.revature.Group4P2.entities.Users;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/cart")
public class CartControllers {
    private CartService service;

    // catalog and user services
    private CatalogService catalogService;
    private UserService userService;

    @Autowired
    public CartControllers(CartService service, CatalogService catalogService, UserService userService) {
        this.service = service;
        this.catalogService = catalogService;
        this.userService = userService;
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
        Optional<Catalog> optionalCatalog = catalogService.getCatalogById(cart.getCatalog().getItemId());
        Optional<Users> optionalUsers = userService.getUserById(cart.getUser().getId());

        if(optionalCatalog.isPresent() && optionalUsers.isPresent()) {
            cart.setCatalog(catalogService.getCatalogById(cart.getCatalog().getItemId()).get());
            cart.setUser(userService.getUserById(cart.getUser().getId()).get());
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
        service.updateCart(cart);
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
            cart.setCatalog(null);
            service.updateCart(cart);
            service.deleteCartById(cartId);
        }

    }

}
