package com.revature.Group4P2.beans.controllers;

import com.revature.Group4P2.beans.services.CartService;
import com.revature.Group4P2.beans.services.PurchaseService;
import com.revature.Group4P2.entities.Cart;
import com.revature.Group4P2.entities.Purchases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/purchases")
public class PurchasesController {
    private PurchaseService service;
    @Autowired
    public PurchasesController(PurchaseService service) {
        this.service = service;
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
        service.createPurchases(purchases);
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
        service.deletePurchasesById(purchaseId);
    }
}
