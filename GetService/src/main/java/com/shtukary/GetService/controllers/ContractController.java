package com.shtukary.GetService.controllers;

import com.shtukary.GetService.models.Contract;
import com.shtukary.GetService.models.Skill;
import com.shtukary.GetService.service.ContractService;
import com.shtukary.GetService.service.SkillService;
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
@RequestMapping("/contract")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContractController {

    @Autowired
    private ContractService contractService;
    private SkillService skillService;

    @GetMapping(path = "/view")
    public List<Contract> getAll(){
        return contractService.findAll();
    }

    @GetMapping("{id}")
    public Contract getOne(@PathVariable("id") Contract contract){
        return contract;
    }

    @PostMapping(path = "/add")
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

    @DeleteMapping("/skill/{id}")
    public void delete(@PathVariable("id") Skill skill){
        skillService.deleteById(skill.getSkillId());
    }

}
