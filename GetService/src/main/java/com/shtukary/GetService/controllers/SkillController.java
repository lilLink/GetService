package com.shtukary.GetService.controllers;

import com.shtukary.GetService.models.Skill;
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
@RequestMapping("skill")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping
    public List<Skill> getAll(){
        return skillService.findAll();
    }

    @GetMapping("{id}")
    public Skill getOne(@PathVariable("id") Skill skill){
        return skill;
    }

    @PostMapping
    public Skill create(@RequestBody Skill skill){
        return skillService.create(skill);
    }

    @PutMapping("{id}")
    public Skill update(@PathVariable("id") Skill skillFromDB, @RequestBody Skill skill){
        BeanUtils.copyProperties(skill, skillFromDB, "id");
        return skillService.update(skillFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Skill skill){
        skillService.deleteById(skill.getSkillId());
    }

}
