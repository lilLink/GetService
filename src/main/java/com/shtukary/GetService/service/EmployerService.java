package com.shtukary.GetService.service;

import com.shtukary.GetService.models.Employer;
import com.shtukary.GetService.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployerService implements AbstractService<Employer> {

    @Autowired
    private EmployerRepository employerRepository;

    @Override
    public Employer findById(Long id) {
        return employerRepository.getOne(id);
    }

    @Override
    public List<Employer> findAll() {
        return employerRepository.findAll();
    }

    @Override
    public Employer create(Employer employer) {
        return employerRepository.save(employer);
    }

    @Override
    public Employer update(Employer employer) {
        return employerRepository.save(employer);
    }

    @Override
    public void deleteById(Long id) {
        employerRepository.deleteById(id);
    }
}
