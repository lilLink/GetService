package com.shtukary.GetService.service;

import com.shtukary.GetService.models.Contract;
import com.shtukary.GetService.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContractService implements AbstractService<Contract> {

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public Contract findById(Long id) {
        return contractRepository.getOne(id);
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Contract create(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public Contract update(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public void deleteById(Long id) {
        contractRepository.deleteById(id);
    }
}
