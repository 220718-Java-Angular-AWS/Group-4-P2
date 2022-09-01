package com.revature.Group4P2.beans.controllers;

import com.revature.Group4P2.beans.services.CatalogDetailsService;
import com.revature.Group4P2.entities.CatalogDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//NOT ENTIRELY SURE IF WE ARE TREATING THIS AS A USER CONTROLLER
//Made the assumption that through the Catalog Details Table we can pull the specific details
// of the Catalog table
@Controller
@RequestMapping(value = "/catalog-details")
public class CatalogDetailsController {
    private CatalogDetailsService service;

    @Autowired
    public CatalogDetailsController(CatalogDetailsService cdService){
        this.service = cdService;
    }

    @RequestMapping(value = "/{catalogDetailsId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody CatalogDetails getCdById(@PathVariable Integer catalogDetailsId){
        Optional<CatalogDetails> optionalCd = service.getCdById(catalogDetailsId);
        return optionalCd.get();
    }

    @RequestMapping(method= RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<CatalogDetails> getAllCd(){
        return service.getAllCd();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void createCd(@RequestBody CatalogDetails cd){
        service.createCd(cd);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(value= HttpStatus.ACCEPTED)
    public void updateCd(@RequestBody CatalogDetails cd){
        service.updateCd(cd);
    }

    @RequestMapping(value= "/{catalogDetailsId}", method = RequestMethod.DELETE)
    @ResponseStatus(value= HttpStatus.OK)
    public void deleteCd(@PathVariable(name = "catalogDetailsId") Integer id){
        service.deleteCdById(id);
    }

}
