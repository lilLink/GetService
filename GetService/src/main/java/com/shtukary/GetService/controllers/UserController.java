package com.shtukary.GetService.controllers;

import com.shtukary.GetService.models.Category;
import com.shtukary.GetService.models.User;
import com.shtukary.GetService.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll(){
        return userService.findAll();
    }

    @GetMapping("{id}")
    public User getOne(@PathVariable("id") User user){
        return user;
    }

    @PostMapping
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @PutMapping("{id}")
    public User update(@PathVariable("id") User userFromDB, @RequestBody User user){
        BeanUtils.copyProperties(user, userFromDB, "id");
        return userService.update(userFromDB);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") User user){
        userService.deleteById(user.getUserId());
    }


}
