package com.shtukary.GetService.controllers;

import com.shtukary.GetService.models.ContractFeedback;
import com.shtukary.GetService.service.ContractFeedBackService;
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
@RequestMapping("feedback")
@CrossOrigin
public class ContractFeedbackController {

    @Autowired
    private ContractFeedBackService contractFeedBackService;

    @GetMapping
    public List<ContractFeedback> getAll(){
        return contractFeedBackService.findAll();
    }

    @GetMapping("{id}")
    public ContractFeedback getOne(@PathVariable("id") ContractFeedback contractFeedback){
        return contractFeedback;
    }

    @PostMapping
    public ContractFeedback create(@RequestBody ContractFeedback contractFeedback){
        return contractFeedBackService.create(contractFeedback);
    }

    @PutMapping("{id}")
    public ContractFeedback update(@PathVariable("id") ContractFeedback contractFeedbackFromDB, @RequestBody ContractFeedback contractFeedback){
        BeanUtils.copyProperties(contractFeedback, contractFeedbackFromDB, "id");
        return contractFeedBackService.update(contractFeedbackFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") ContractFeedback contractFeedback){
        contractFeedBackService.deleteById(contractFeedback.getContractFeedbackId());
    }

}
