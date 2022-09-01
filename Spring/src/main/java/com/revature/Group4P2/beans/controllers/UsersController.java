package com.revature.Group4P2.beans.controllers;

import com.revature.Group4P2.beans.services.UsersService;
import com.revature.Group4P2.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/users")
public class UsersController {
    private UsersService service;


    @Autowired
    public UsersController(UsersService usersService){
        this.service = usersService;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody Users getUserById(@PathVariable Integer userId){
        Optional<Users> optionalUser = service.getUserById(userId);
        return optionalUser.get();
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<Users> getAllUsers(){
        return service.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void createUser(@RequestBody Users user){
        service.createUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void updateUser(@RequestBody Users user){
        service.updateUser(user);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteUser(@PathVariable(name = "userId") Integer id){
        service.deleteById(id);
    }

}
