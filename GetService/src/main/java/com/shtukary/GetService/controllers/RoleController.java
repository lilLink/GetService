package com.shtukary.GetService.controllers;

import com.shtukary.GetService.models.Role;
import com.shtukary.GetService.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
@CrossOrigin
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getAll(){
        return roleService.findAll();
    }

    @GetMapping("{id}")
    public Role getOne(@PathVariable("id") Role role){
        return role;
    }

    @PostMapping
    public Role create(@RequestBody Role role){
        return roleService.create(role);
    }

    @PutMapping("{id}")
    public Role update(@PathVariable("id") Role roleFromDB, @RequestBody Role role){
        BeanUtils.copyProperties(role, roleFromDB, "id");
        return roleService.update(roleFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Role role){
        roleService.deleteById(role.getRoleId());
    }

}
