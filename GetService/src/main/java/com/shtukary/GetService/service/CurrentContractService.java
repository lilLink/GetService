package com.shtukary.GetService.service;

import com.shtukary.GetService.models.CurrentContract;
import com.shtukary.GetService.repos.CurrentContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CurrentContractService implements AbstractService<CurrentContract> {

    @Autowired
    private CurrentContactRepository currentContactRepository;

    @Override
    public CurrentContract findById(Long id) {
        return currentContactRepository.getOne(id);
    }

    @Override
    public List<CurrentContract> findAll() {
        return currentContactRepository.findAll();
    }

    @Override
    public CurrentContract create(CurrentContract currentContract) {
        return currentContactRepository.save(currentContract);
    }

    @Override
    public CurrentContract update(CurrentContract currentContract) {
        return currentContactRepository.save(currentContract);
    }

    @Override
    public void deleteById(Long id) {
        currentContactRepository.deleteById(id);
    }
}
