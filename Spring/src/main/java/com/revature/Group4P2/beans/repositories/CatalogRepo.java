package com.revature.Group4P2.beans.repositories;

import com.revature.Group4P2.entities.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepo extends JpaRepository<Catalog, Integer> {
}
