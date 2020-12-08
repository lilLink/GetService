package com.shtukary.ita.service;


import com.shtukary.ita.model.Education;

import java.util.List;
import java.util.Optional;

public interface EducationService {

    Optional<Education> findById(Long id);

    List<Education> findAll();

    Education save(Education education);

    Education update(Education education);

    void deleteById(Long id);

}
