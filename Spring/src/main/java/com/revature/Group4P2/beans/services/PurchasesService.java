package com.revature.Group4P2.beans.services;

import com.revature.Group4P2.beans.repositories.PurchasesRepo;
import com.revature.Group4P2.entities.Purchases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchasesService {
    PurchasesRepo repo;

    @Autowired
    public PurchasesService(PurchasesRepo purchasesRepo){
        this.repo = purchasesRepo;
    }

    public Optional<Purchases> getPurchasesById(Integer id){
        return repo.findById(id);
    }

    public List<Purchases> getAllPurchases(){
        return repo.findAll();
    }

    public void createPurchase(Purchases purchase){
        repo.save(purchase);
    }

    public void updatePurchase(Purchases purchase){
        repo.save(purchase);
    }

    public void deletePurchaseById(Integer id){
        repo.deleteById(id);
    }

}
