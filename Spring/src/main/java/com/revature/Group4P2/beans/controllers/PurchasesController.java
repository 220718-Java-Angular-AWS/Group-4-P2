package com.revature.Group4P2.beans.controllers;

import com.revature.Group4P2.beans.services.PurchasesService;
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
    private PurchasesService service;

    @Autowired
    public PurchasesController(PurchasesService purchasesService){
        this.service = purchasesService;
    }

    @RequestMapping(value = "/{purchaseId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody Purchases getPurchaseById(@PathVariable Integer purchaseId){
        Optional<Purchases> optionalPurchase = service.getPurchasesById(purchaseId);
        return optionalPurchase.get();
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<Purchases> getAllPurchases(){
        return service.getAllPurchases();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void createPurchase(@RequestBody Purchases purchase){
        service.createPurchase(purchase);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void updatePurchase(@RequestBody Purchases purchase){
        service.updatePurchase(purchase);
    }

    @RequestMapping(value = "/{purchaseId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deletePurchase(@PathVariable(name = "purchaseId") Integer id){
        service.deletePurchaseById(id);
    }

}



















