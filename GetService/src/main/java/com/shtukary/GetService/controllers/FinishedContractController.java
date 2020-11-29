package com.shtukary.GetService.controllers;

import com.shtukary.GetService.models.FinishedContract;
import com.shtukary.GetService.service.FinishedContractService;
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
@RequestMapping("finishedcontract")
@CrossOrigin
public class FinishedContractController {

    @Autowired
    private FinishedContractService finishedContractService;

    @GetMapping
    public List<FinishedContract> getAll(){
        return finishedContractService.findAll();
    }

    @GetMapping("{id}")
    public FinishedContract getOne(@PathVariable("id") FinishedContract finishedContract){
        return finishedContract;
    }

    @PostMapping
    public FinishedContract create(@RequestBody FinishedContract finishedContract){
        return finishedContractService.create(finishedContract);
    }

    @PutMapping("{id}")
    public FinishedContract update(@PathVariable("id") FinishedContract finishedContractFromDB, @RequestBody FinishedContract finishedContract){
        BeanUtils.copyProperties(finishedContract, finishedContractFromDB, "id");
        return finishedContractService.update(finishedContractFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") FinishedContract finishedContract){
        finishedContractService.deleteById(finishedContract.getContractId());
    }

}
