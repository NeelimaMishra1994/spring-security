package com.lado.springsecurity.services;

import com.lado.springsecurity.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    List<User> list = new ArrayList<>();

    public UserService(){
        list.add(new User("abc","abc","abc@gmail.com"));
        list.add(new User("xyz","xyz","xyz@gmail.com"));
    }
    //get all users

    public List<User> getList() {
        return this.list;
    }
    //get single user
    public User getSingleuser(String username){
        return this.list.stream().filter((User -> User.getUsername().equals(username))).findAny().orElse(null);
    }
    //add new user
    public User addUser(User user){
        this.list.add(user);
        return user;
    }
}
