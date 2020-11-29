package com.shtukary.GetService.controllers;

import com.shtukary.GetService.models.Category;
import com.shtukary.GetService.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
@CrossOrigin
public class HomeController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public String getHome(){
        return "Home";
    }

    @GetMapping(value = "/find")
    public List<Category> get(){
        return categoryService.findAll();
    }
}
