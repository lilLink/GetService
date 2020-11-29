package com.shtukary.GetService.service;

import com.shtukary.GetService.models.PendingContract;
import com.shtukary.GetService.repos.PendingContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PendingContractService implements AbstractService<PendingContract> {

    @Autowired
    private PendingContractRepository pendingContractRepository;

    @Override
    public PendingContract findById(Long id) {
        return pendingContractRepository.getOne(id);
    }

    @Override
    public List<PendingContract> findAll() {
        return pendingContractRepository.findAll();
    }

    @Override
    public PendingContract create(PendingContract pendingContract) {
        return pendingContractRepository.save(pendingContract);
    }

    @Override
    public PendingContract update(PendingContract pendingContract) {
        return pendingContractRepository.save(pendingContract);
    }

    @Override
    public void deleteById(Long id) {
        pendingContractRepository.deleteById(id);
    }
}
