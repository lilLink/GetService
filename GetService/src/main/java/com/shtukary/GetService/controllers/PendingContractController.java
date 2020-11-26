package com.shtukary.GetService.controllers;

import com.shtukary.GetService.models.PendingContract;
import com.shtukary.GetService.service.PendingContractService;
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
@RequestMapping("pendingcontract")
@CrossOrigin
public class PendingContractController {

    @Autowired
    private PendingContractService pendingContractService;

    @GetMapping
    public List<PendingContract> getAll(){
        return pendingContractService.findAll();
    }

    @GetMapping("{id}")
    public PendingContract getOne(@PathVariable("id") PendingContract pendingContract){
        return pendingContract;
    }

    @PostMapping
    public PendingContract create(@RequestBody PendingContract pendingContract){
        return pendingContractService.create(pendingContract);
    }

    @PutMapping("{id}")
    public PendingContract update(@PathVariable("id") PendingContract pendingContractFromDB, @RequestBody PendingContract pendingContract){
        BeanUtils.copyProperties(pendingContract, pendingContractFromDB, "id");
        return pendingContractService.update(pendingContractFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") PendingContract pendingContract){
        pendingContractService.deleteById(pendingContract.getContractId());
    }

}
