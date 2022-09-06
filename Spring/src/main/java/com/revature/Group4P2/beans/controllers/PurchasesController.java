package com.revature.Group4P2.beans.controllers;

import com.revature.Group4P2.beans.services.CartService;
import com.revature.Group4P2.beans.services.CatalogService;
import com.revature.Group4P2.beans.services.PurchaseService;
import com.revature.Group4P2.beans.services.UserService;
import com.revature.Group4P2.entities.Cart;
import com.revature.Group4P2.entities.Catalog;
import com.revature.Group4P2.entities.Purchases;
import com.revature.Group4P2.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/purchases")
public class PurchasesController {
    private PurchaseService service;
    private CatalogService catalogService;
    private UserService userService;

    private  CartService cartService;
    @Autowired
    public PurchasesController(PurchaseService service, CatalogService catalogService, UserService userService, CartService cartService) {
        this.service = service;
        this.catalogService = catalogService;
        this.userService = userService;
        this.cartService = cartService;
    }

    //5 crud things:
    // GET - read by id- find,
    @RequestMapping(value = "/{purchasesId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody Purchases getPurchasesById(@PathVariable Integer purchasesId)
    {
        Optional<Purchases> optionalPurchases = service.getPurchaseById(purchasesId);
        return optionalPurchases.get();
    }

    // custom
    @RequestMapping(value = "getAllPurchaseById/{getAllPurchaseById}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<Purchases> getAllPurchasesById(@PathVariable Integer getAllPurchaseById)
    {
        List<Purchases> purchases = service.getAllPurchasesById(getAllPurchaseById);
        return purchases;
    }
    // GET - read all - find all,
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<Purchases> getAllPurchases()
    {
        return service.getAllPurchases();
    }


    // POST - create - save,
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void createPurchases(@RequestBody Purchases purchases)
    {
        // catalog and user
        Optional<Catalog> optionalCatalog = catalogService.getCatalogById(purchases.getCatalog().getItemId());
        Optional<Users> optionalUsers = userService.getUserById(purchases.getUser().getId());
        Optional<Cart> optionalCart = cartService.getCartById(purchases.getCart().getItemId());
        if(optionalUsers.isPresent() && optionalCatalog.isPresent() && optionalCart.isPresent())
        {
            purchases.setCatalog(catalogService.getCatalogById(purchases.getCatalog().getItemId()).get());
            purchases.setUser(userService.getUserById(purchases.getUser().getId()).get());
            purchases.setCart(cartService.getCartById(purchases.getCart().getItemId()).get());
            purchases.setQuantityPurchased(cartService.getCartById(purchases.getCart().getItemId()).get().getQuantity());
            Double totalAmount = purchases.getCart().getCatalog().getItemPrice() * purchases.getQuantityPurchased();
            purchases.setTotalAmount(totalAmount);
            service.createPurchases(purchases);
        }

        else
        {
            // throw exception later on
            System.out.println("Purchase ITEM NOT CREATED");
        }

    }


    // PUT/PATCH - update - save,
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void updatePurchases(@RequestBody Purchases purchases)
    {
        service.updatePurchases(purchases);
    }
    // DELETE - delete - delete
    @RequestMapping(value = "/{purchaseId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deletePurchases(@PathVariable Integer purchaseId)
    {
        Optional<Purchases> optionalPurchases = service.getPurchaseById(purchaseId);
        if(optionalPurchases.isPresent())
        {
            // then set its foreign keys to null and update the db
            Purchases purchases = optionalPurchases.get();
            purchases.setUser(null);
            purchases.setCatalog(null);
            service.updatePurchases(purchases);
            service.deletePurchasesById(purchaseId);
        }

    }
}
