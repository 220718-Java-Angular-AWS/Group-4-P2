package com.revature.Group4P2.beans.services;

import com.revature.Group4P2.beans.repositories.CatalogDetailsRepo;
import com.revature.Group4P2.entities.CatalogDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogDetailsService {
    CatalogDetailsRepo repo;

    @Autowired
    public CatalogDetailsService(CatalogDetailsRepo cdRepo){
        this.repo = cdRepo;
    }

    public List<CatalogDetails> getAllCd(){
        return repo.findAll();
    }

    public Optional<CatalogDetails> getCdById(Integer id){
        return repo.findById(id);
    }

    public void createCd(CatalogDetails cd){
        repo.save(cd);
    }

    public void updateCd(CatalogDetails cd){
        repo.save(cd);
    }
    public void deleteCdById(Integer id){
        repo.deleteById(id);
    }
}
