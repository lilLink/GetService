package com.shtukary.GetService.controllers;

import com.shtukary.GetService.models.StartedContract;
import com.shtukary.GetService.service.StartedContractService;
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
@RequestMapping("startedcontract")
@CrossOrigin
public class StartedContractController {

    @Autowired
    private StartedContractService startedContractService;

    @GetMapping
    public List<StartedContract> getAll(){
        return startedContractService.findAll();
    }

    @GetMapping("{id}")
    public StartedContract getOne(@PathVariable("id") StartedContract startedContract){
        return startedContract;
    }

    @PostMapping
    public StartedContract create(@RequestBody StartedContract startedContract){
        return startedContractService.create(startedContract);
    }

    @PutMapping("{id}")
    public StartedContract update(@PathVariable("id") StartedContract startedContractFromDB, @RequestBody StartedContract startedContract){
        BeanUtils.copyProperties(startedContract, startedContractFromDB, "id");
        return startedContractService.update(startedContractFromDB);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") StartedContract startedContract){
        startedContractService.deleteById(startedContract.getStartedContractId());
    }



}
