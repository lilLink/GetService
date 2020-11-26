package com.shtukary.GetService.controllers;

import com.shtukary.GetService.models.CurrentContract;
import com.shtukary.GetService.service.CurrentContractService;
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
@RequestMapping("currentcontract")
@CrossOrigin
public class CurrentContractController {

    @Autowired
    private CurrentContractService currentContractService;

    @GetMapping
    public List<CurrentContract> getAll(){
        return currentContractService.findAll();
    }

    @GetMapping("{id}")
    public CurrentContract getOne(@PathVariable("id") CurrentContract currentContract){
        return currentContract;
    }

    @PostMapping
    public CurrentContract create(@RequestBody CurrentContract currentContract){
        return currentContractService.create(currentContract);
    }

    @PutMapping("{id}")
    public CurrentContract update(@PathVariable("id") CurrentContract currentContractFromDB, @RequestBody CurrentContract currentContract){
        BeanUtils.copyProperties(currentContract, currentContractFromDB, "id");
        return currentContractService.update(currentContractFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") CurrentContract currentContract){
        currentContractService.deleteById(currentContract.getCurrentId());
    }

}
