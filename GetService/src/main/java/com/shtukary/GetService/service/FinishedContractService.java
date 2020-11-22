package com.shtukary.GetService.service;

import com.shtukary.GetService.models.FinishedContract;
import com.shtukary.GetService.repos.FinishedContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FinishedContractService implements AbstractService<FinishedContract> {

    @Autowired
    private FinishedContractRepository finishedContractRepository;

    @Override
    public FinishedContract findById(Long id) {
        return finishedContractRepository.getOne(id);
    }

    @Override
    public List<FinishedContract> findAll() {
        return finishedContractRepository.findAll();
    }

    @Override
    public FinishedContract create(FinishedContract finishedContract) {
        return finishedContractRepository.save(finishedContract);
    }

    @Override
    public FinishedContract update(FinishedContract finishedContract) {
        return finishedContractRepository.save(finishedContract);
    }

    @Override
    public void deleteById(Long id) {
        finishedContractRepository.deleteById(id);
    }
}
