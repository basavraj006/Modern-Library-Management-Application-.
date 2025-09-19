package com.RestApi.LMS.Controllers;


import com.RestApi.LMS.module.User;
import com.RestApi.LMS.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/books/users")
public class userController {

    @Autowired
    private Userservice userservice;

    @GetMapping("/all")
    public List<User> getAllUser(){
        return userservice.findAll(Sort.by(Sort.by(Sort.Direction.ASC,"id").toList()));
    }

    @PostMapping("/save")
    public User SaveUser(@RequestBody User user){
        return userservice.saveUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int UserId){
        return userservice.deleteUser(UserId);
    }
}
