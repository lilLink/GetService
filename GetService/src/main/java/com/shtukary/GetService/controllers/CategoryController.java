package com.shtukary.GetService.controllers;

import com.shtukary.GetService.models.Category;
import com.shtukary.GetService.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAll(){
        return categoryService.findAll();
    }

    @GetMapping("{id}")
    public Category getOne(@PathVariable("id") Category category){
        return category;
    }

    @PostMapping
    public Category create(@RequestBody Category category){
        return categoryService.create(category);
    }

    @PutMapping("{id}")
    public Category update(@PathVariable("id") Category categoryFromDB, @RequestBody Category category){
        BeanUtils.copyProperties(category, categoryFromDB, "id");
        return categoryService.update(categoryFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Category category){
        categoryService.deleteById(category.getCategoryId());
    }

}
