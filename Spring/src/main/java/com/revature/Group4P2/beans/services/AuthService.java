package com.revature.Group4P2.beans.services;

import com.revature.Group4P2.beans.Exceptions.AccessDeniedException;
import com.revature.Group4P2.beans.repositories.UsersRepo;

import com.revature.Group4P2.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AuthService {

    private UsersRepo repo;

    @Autowired
    private AuthService(UsersRepo usersRepo) {
        this.repo = usersRepo;
    }

    public Users authenticate(String username, String password) throws AccessDeniedException {
        Optional<Users> result = repo.findByUsername(username);
        if(result.isPresent() && result.get().getPassword().equals(password)) {
            return result.get();
        } else {
            throw new AccessDeniedException("Username or Password mismatch");
        }
    }
}
