package com.revature.Group4P2.beans.services;

import com.revature.Group4P2.beans.repositories.CartRepo;
import com.revature.Group4P2.entities.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    CartRepo repo;

    @Autowired
    public CartService(CartRepo cartRepo){
        this.repo = cartRepo;
    }

    public Optional<Cart> getCartById(Integer id){
        return repo.findById(id);
    }

    //Not sure if this function would be required for the project
    public List<Cart> getAllCarts(){
        return repo.findAll();
    }

    public void createCart(Cart cart){
        repo.save(cart);
    }

    public void updateCart(Cart cart){
        repo.save(cart);
    }

    public void deleteCart(Integer id){
        repo.deleteById(id);
    }
}
