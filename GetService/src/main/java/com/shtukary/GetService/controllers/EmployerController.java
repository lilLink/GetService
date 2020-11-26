package com.shtukary.GetService.controllers;

import com.shtukary.GetService.models.Employer;
import com.shtukary.GetService.service.EmployerService;
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
@RequestMapping("employer")
@CrossOrigin
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @GetMapping
    public List<Employer> getAll(){
        return employerService.findAll();
    }

    @GetMapping("{id}")
    public Employer getOne(@PathVariable("id") Employer employer){
        return employer;
    }

    @PostMapping
    public Employer create(@RequestBody Employer employer){
        return employerService.create(employer);
    }

    @PutMapping("{id}")
    public Employer update(@PathVariable("id") Employer employerFromDB, @RequestBody Employer employer){
        BeanUtils.copyProperties(employer, employerFromDB, "id");
        return employerService.update(employerFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Employer employer){
        employerService.deleteById(employer.getEmployerId());
    }

}
