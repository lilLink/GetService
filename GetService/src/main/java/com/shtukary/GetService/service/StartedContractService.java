package com.shtukary.GetService.service;

import com.shtukary.GetService.models.StartedContract;
import com.shtukary.GetService.repos.StartedContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StartedContractService implements AbstractService<StartedContract> {

    @Autowired
    StartedContractRepository startedContractRepository;

    @Override
    public StartedContract findById(Long id) {
        return startedContractRepository.getOne(id);
    }

    @Override
    public List<StartedContract> findAll() {
        return startedContractRepository.findAll();
    }

    @Override
    public StartedContract create(StartedContract startedContract) {
        return startedContractRepository.save(startedContract);
    }

    @Override
    public StartedContract update(StartedContract startedContract) {
        return startedContractRepository.save(startedContract);
    }

    @Override
    public void deleteById(Long id) {
        startedContractRepository.deleteById(id);
    }
}
