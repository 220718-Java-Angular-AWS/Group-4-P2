package com.revature.Group4P2.beans.repositories;

import com.revature.Group4P2.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Integer> {
}
