package com.shtukary.GetService.controllers;

import com.shtukary.GetService.models.UserInfo;
import com.shtukary.GetService.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/info")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/all")
    public List<UserInfo> getAll(){
        return userInfoService.findAll();
    }

    @GetMapping("{id}")
    public UserInfo getOne(@PathVariable("id") UserInfo userInfo){
        return userInfoService.findById(userInfo.getInfoId());
    }

    @PostMapping("/add")
    public UserInfo create(@RequestBody UserInfo userInfo){
        return userInfoService.create(userInfo);
    }

    @PutMapping("/update")
    public UserInfo update(@RequestBody UserInfo userInfo){
        return userInfoService.update(userInfo);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") UserInfo userInfo){
        userInfoService.deleteById(userInfo.getInfoId());
    }
}
