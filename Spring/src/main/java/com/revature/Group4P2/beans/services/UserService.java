package com.revature.Group4P2.beans.services;

import com.revature.Group4P2.beans.repositories.UsersRepo;
import com.revature.Group4P2.entities.Users;
import com.revature.Group4P2.exceptions.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UsersRepo repo;
    ValidateService validate;

    @Autowired
    public UserService(UsersRepo userRepo, ValidateService validateService) {
        this.repo = userRepo;
        this.validate = validateService;
    }


    @Autowired
    public UserService(UsersRepo usersRepo)
    {
        this.repo = usersRepo;
    }

    // crud repo
    // get by id
    public Optional<Users> getUserById(Integer id)
    {
        return repo.findById(id);
    }

    // get all
    public List<Users> getAllUsers()
    {
        return repo.findAll();
    }

    // create
    public void createUsers(Users users) throws InvalidInputException {
        if(validate.validateUsers(users)) {
            repo.save(users);
        } else {
            throw new InvalidInputException("Failed to create account!");
        }
    }

    // update
    public void updateUser(Users user)
    {
        repo.save(user);
    }

    // delete
    public void deleteUserById(Integer id)
    {
        repo.deleteById(id);
    }


}
