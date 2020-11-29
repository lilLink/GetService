package com.shtukary.GetService.controllers;

import com.shtukary.GetService.models.Contract;
import com.shtukary.GetService.service.ContractService;
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
@RequestMapping("contract")
@CrossOrigin
public class ContractController {

    @Autowired
    private ContractService contractService;

    @GetMapping
    public List<Contract> getAll(){
        return contractService.findAll();
    }

    @GetMapping("{id}")
    public Contract getOne(@PathVariable("id") Contract contract){
        return contract;
    }

    @PostMapping
    public Contract create(@RequestBody Contract contract){
        return contractService.create(contract);
    }

    @PutMapping("{id}")
    public Contract update(@PathVariable("id") Contract contractFromDB, @RequestBody Contract contract){
        BeanUtils.copyProperties(contract, contractFromDB, "id");
        return contractService.update(contractFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Contract contract){
        contractService.deleteById(contract.getContractId());
    }

}
