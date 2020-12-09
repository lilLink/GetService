package com.shtukary.GetService.controllers;

import com.shtukary.GetService.models.Contract;
import com.shtukary.GetService.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @GetMapping("/all")
    public List<Contract> getAll(){
        return contractService.findAll();
    }
    @GetMapping("{id}")
    public Contract getOne(@PathVariable("id") Contract contract){
        return contractService.findById(contract.getContractId());
    }

    @PostMapping("/add")
    public Contract create(@RequestBody Contract contract){
        return contractService.create(contract);
    }

    @PutMapping("/update")
    public Contract update(@RequestBody Contract contract){
        return contractService.update(contract);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Contract contract){
        contractService.deleteById(contract.getContractId());
    }
}
