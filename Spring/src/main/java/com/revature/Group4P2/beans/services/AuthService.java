package com.revature.Group4P2.beans.services;

import com.revature.Group4P2.beans.repositories.UsersRepo;
import com.revature.Group4P2.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Optional;

@Service
public class AuthService {
    private UsersRepo repo;

    @Autowired
    public AuthService(UsersRepo userRepo) {
        this.repo = userRepo;
    }

    public Users authenticate(String username, String password) throws AccessDeniedException {
        Optional<Users> result = repo.findByUsername(username);
        if(result.isPresent() && result.get().getPassword().equals(password)) {
            return result.get();
        } else {
            throw new AccessDeniedException("Login failed - Check Credentials!");
        }

    }
}
