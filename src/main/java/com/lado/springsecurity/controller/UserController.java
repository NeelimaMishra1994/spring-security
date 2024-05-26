package com.lado.springsecurity.controller;

import com.lado.springsecurity.models.User;
import com.lado.springsecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserController {


    @Autowired
    private UserService userService;

    //get all Users
    @GetMapping("/")
    public List<User> getAllUser(){
        return this.userService.getList();
    }
    //get single user
    //@PreAuthorize("hasRole('admin')")this is same thing as ant matcher
    @GetMapping("/{username}")
    public User getSingleUser(@PathVariable ("username") String username){
        return this.userService.getSingleuser(username);
    }
    @PostMapping("/")
    public User addUser(@RequestBody User user){//because jo data aayaega knha aayega body me to json me aaye isliye requestBody use krte hai
        return this.userService.addUser(user);
    }

}
