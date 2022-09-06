package com.revature.Group4P2.beans.services;

import com.revature.Group4P2.beans.repositories.PurchasesRepo;
import com.revature.Group4P2.entities.Purchases;
import com.revature.Group4P2.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    PurchasesRepo repo;

    @Autowired
    public PurchaseService(PurchasesRepo repo) {
        this.repo = repo;
    }

    // crud repo

    // get by id
    public Optional<Purchases> getPurchaseById(Integer id)
    {
//        Purchases purchases = repo.findById(id).get();
        return repo.findById(id);
    }

    public List<Purchases> getAllPurchasesById(Integer id)
    {
        return repo.findAllPurchasesByUsersId(id);
    }
    // get all
    public List<Purchases> getAllPurchases()
    {
        return repo.findAll();
    }

    // create
    public void createPurchases(Purchases purchases)
    {
        repo.save(purchases);
    }

    // update
    public void updatePurchases(Purchases purchases)
    {
        repo.save(purchases);
    }

    // delete
    public void deletePurchasesById(Integer id)
    {
        repo.deleteById(id);
    }


}
