package com.shtukary.GetService.controllers;

import com.shtukary.GetService.models.Employer;
import com.shtukary.GetService.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employer")
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @GetMapping("/all")
    public List<Employer> getAll(){
        return employerService.findAll();
    }
    @GetMapping("{id}")
    public Employer getOne(@PathVariable("id") Employer contract){
        return employerService.findById(contract.getEmployerId());
    }

    @PostMapping("/add")
    public Employer create(@RequestBody Employer contract){
        return employerService.create(contract);
    }

    @PutMapping("/update")
    public Employer update(@RequestBody Employer contract){
        return employerService.update(contract);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Employer contract){
        employerService.deleteById(contract.getEmployerId());
    }
}
