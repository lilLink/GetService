package com.shtukary.GetService.controllers;

import com.shtukary.GetService.models.Contractor;
import com.shtukary.GetService.service.ContractorService;
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
@RequestMapping("contractor")
@CrossOrigin
public class ContractorController {

    @Autowired
    private ContractorService contractorService;

    @GetMapping
    public List<Contractor> getAll(){
        return contractorService.findAll();
    }

    @GetMapping("{id}")
    public Contractor getOne(@PathVariable("id") Contractor contractor){
        return contractor;
    }

    @PostMapping
    public Contractor create(@RequestBody Contractor contractor){
        return contractorService.create(contractor);
    }

    @PutMapping("{id}")
    public Contractor update(@PathVariable("id") Contractor contractorFromDB, @RequestBody Contractor contractor){
        BeanUtils.copyProperties(contractor, contractorFromDB, "id");
        return contractorService.update(contractorFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Contractor contractor){
        contractorService.deleteById(contractor.getContractorId());
    }

}
