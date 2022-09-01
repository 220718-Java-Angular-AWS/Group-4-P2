package com.revature.Group4P2.beans.services;

import com.revature.Group4P2.beans.repositories.CatalogRepo;
import com.revature.Group4P2.entities.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogService {
    CatalogRepo repo;

    @Autowired
    public CatalogService(CatalogRepo catalogRepo){
        this.repo = catalogRepo;
    }

    public Optional<Catalog> getCatalogById(Integer id){
        return repo.findById(id);
    }

    public List<Catalog> getAllCatalogs(){
        return repo.findAll();
    }

    public void createCatalog(Catalog catalog){
        repo.save(catalog);
    }

    public void updateCatalog(Catalog catalog){
        repo.save(catalog);
    }

    public void deleteCatalogById(Integer id){
        repo.deleteById(id);
    }
}
