package com.revature.Group4P2.beans.repositories;

import com.revature.Group4P2.beans.entities.Purchases;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchasesRepo extends JpaRepository<Purchases, Integer> {
}
