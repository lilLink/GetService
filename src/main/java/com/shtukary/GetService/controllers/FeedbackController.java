package com.shtukary.GetService.controllers;

import com.shtukary.GetService.models.Feedback;
import com.shtukary.GetService.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/all")
    public List<Feedback> getAll(){
        return feedbackService.findAll();
    }
    @GetMapping("{id}")
    public Feedback getOne(@PathVariable("id") Feedback feedback){
        return feedbackService.findById(feedback.getFeedbackId());
    }

    @PostMapping("/add")
    public Feedback create(@RequestBody Feedback feedback){
        return feedbackService.create(feedback);
    }

    @PutMapping("/update")
    public Feedback update(@RequestBody Feedback feedback){
        return feedbackService.update(feedback);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Feedback feedback){
        feedbackService.deleteById(feedback.getFeedbackId());
    }
}
