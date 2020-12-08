package com.shtukary.ita.service;

import com.shtukary.ita.model.Job;

import java.util.List;
import java.util.Optional;

public interface JobService {

    Optional<Job> findById(Long id);

    List<Job> findAll();

    Job save(Job job);

    Job update(Job job);

    void deleteById(Long id);

}
