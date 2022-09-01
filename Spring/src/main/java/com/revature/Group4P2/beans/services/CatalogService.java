package com.revature.Group4P2.beans.services;

import com.revature.Group4P2.beans.repositories.CatalogRepo;
import com.revature.Group4P2.beans.repositories.UsersRepo;
import com.revature.Group4P2.entities.Catalog;
import com.revature.Group4P2.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogService {

    CatalogRepo repo;

    @Autowired
    public CatalogService(CatalogRepo catalogRepo)
    {
        this.repo = catalogRepo;
    }

    // crud repo

    // get by id
    public Optional<Catalog> getCatalogById(Integer id)
    {
        return repo.findById(id);
    }

    // get all
    public List<Catalog> getAllCatalog()
    {
        return repo.findAll();
    }

    // create
    public void createCatalog(Catalog catalog)
    {
        System.out.println("Catalog: " + catalog);

        repo.save(catalog);
    }

    // update
    public void updateCatalog(Catalog catalog)
    {
        repo.save(catalog);
    }

    // delete
    public void deleteCatalogById(Integer id)
    {
        repo.deleteById(id);
    }
}
