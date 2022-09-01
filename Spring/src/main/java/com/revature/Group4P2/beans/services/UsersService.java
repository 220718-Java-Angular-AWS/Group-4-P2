package com.revature.Group4P2.beans.services;

import com.revature.Group4P2.beans.repositories.UsersRepo;
import com.revature.Group4P2.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    UsersRepo repo;

    @Autowired
    public UsersService(UsersRepo usersRepo){
        this.repo = usersRepo;
    }

    //CRUD Functionality

    public List<Users> getAllUsers(){
        return repo.findAll();
    }

    public Optional<Users> getUserById(Integer id){
        return repo.findById(id);
    }

    public void createUser(Users user){
        repo.save(user);
    }

    public void updateUser(Users user){
        repo.save(user);
    }

    public void deleteById(Integer id){
        repo.deleteById(id);
    }

}
