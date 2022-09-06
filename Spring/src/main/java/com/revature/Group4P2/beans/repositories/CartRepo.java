package com.revature.Group4P2.beans.repositories;

import com.revature.Group4P2.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {

    // NOTE: here make other needed queries
    // helpful site: https://www.tutorialspoint.com/spring_boot_jpa/spring_boot_jpa_native_queries.htm
}
