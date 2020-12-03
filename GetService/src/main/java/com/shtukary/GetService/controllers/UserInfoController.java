package com.shtukary.GetService.controllers;

import com.shtukary.GetService.models.User;
import com.shtukary.GetService.models.UserInfo;
import com.shtukary.GetService.service.UserInfoService;
import com.shtukary.GetService.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("userinfo")
@CrossOrigin
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping
    public List<UserInfo> getAll(){
        return userInfoService.findAll();
    }

    @GetMapping("{id}")
    public UserInfo getOne(@PathVariable("id") UserInfo userInfo){
        return userInfo;
    }

    @PostMapping
    public UserInfo create(@RequestBody UserInfo userInfo){
        return userInfoService.create(userInfo);
    }

    @PutMapping("{id}")
    public UserInfo update(@PathVariable("id") UserInfo userInfoFromDB, @RequestBody UserInfo userInfo){
        BeanUtils.copyProperties(userInfo, userInfoFromDB, "id");
        return userInfoService.update(userInfoFromDB);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UserInfo userInfo){
        userInfoService.deleteById(userInfo.getUserId());
    }

}
