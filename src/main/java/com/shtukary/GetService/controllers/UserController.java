package com.shtukary.GetService.controllers;

import com.shtukary.GetService.models.User;
import com.shtukary.GetService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.findAll();
    }

    @GetMapping("{id}")
    public User getOne(@PathVariable("id") User user){
        return userService.findById(user.getUserId());
    }

    @PostMapping("/add")
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @PutMapping("/update")
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") User user){
        userService.deleteById(user.getUserId());
    }
}
