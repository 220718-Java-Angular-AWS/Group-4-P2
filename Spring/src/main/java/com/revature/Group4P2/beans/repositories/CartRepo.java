package com.revature.Group4P2.beans.repositories;

import com.revature.Group4P2.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, Integer> {
}
