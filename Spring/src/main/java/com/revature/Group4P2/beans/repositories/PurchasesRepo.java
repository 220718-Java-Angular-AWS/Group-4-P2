package com.revature.Group4P2.beans.repositories;
import com.revature.Group4P2.entities.Purchases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchasesRepo extends JpaRepository<Purchases, Integer> {

    @Query("FROM purchases WHERE user_user_id =  :userId")
    public List<Purchases> findAllPurchasesByUsersId(@Param("userId") Integer userId);


}
