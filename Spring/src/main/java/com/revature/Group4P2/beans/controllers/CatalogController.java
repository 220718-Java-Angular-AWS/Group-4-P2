package com.revature.Group4P2.beans.controllers;

import com.revature.Group4P2.beans.services.CatalogService;
import com.revature.Group4P2.entities.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/catalog")
public class CatalogController {

    private CatalogService service;

    @Autowired
    public CatalogController(CatalogService catalogService) {
        this.service = catalogService;
    }

    @RequestMapping(value = "/{itemId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody Catalog getCatalogById(@PathVariable Integer itemId) {
        Optional<Catalog> optionalCatalog = service.getCatalogById(itemId);
        return optionalCatalog.get();
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<Catalog> getAllCatalogs() {
        return service.getAllCatalogs();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void createCatalog(@RequestBody Catalog catalog) {
        service.createCatalog(catalog);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void updateCatalog(@RequestBody Catalog catalog) {
        service.updateCatalog(catalog);
    }

    @RequestMapping(value = "/{itemId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deletePurchase(@PathVariable(name = "itemId") Integer id) {
        service.deleteCatalogById(id);
    }
}

