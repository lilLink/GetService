package com.shtukary.GetService.service;

import com.shtukary.GetService.models.Feedback;
import com.shtukary.GetService.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FeedbackService implements AbstractService<Feedback> {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public Feedback findById(Long id) {
        return feedbackRepository.getOne(id);
    }

    @Override
    public List<Feedback> findAll() {
        return feedbackRepository.findAll();
    }

    @Override
    public Feedback create(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public Feedback update(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public void deleteById(Long id) {
        feedbackRepository.deleteById(id);
    }
}
