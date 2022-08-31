package com.revature.Group4P2.beans.repositories;

import com.revature.Group4P2.beans.entities.CatalogDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogDetailsRepo extends JpaRepository<CatalogDetails, Integer> {
}
