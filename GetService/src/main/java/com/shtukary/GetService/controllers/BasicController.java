package com.shtukary.GetService.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
@CrossOrigin
public class BasicController {

    @GetMapping
    public ModelAndView get(){
        return new ModelAndView( "redirect:" + "/home");
    }
}
