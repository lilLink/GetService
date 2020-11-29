package com.shtukary.GetService.service;

import com.shtukary.GetService.models.Contractor;
import com.shtukary.GetService.repos.ContractorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContractorService implements AbstractService<Contractor> {

    @Autowired
    private ContractorRepository contractorRepository;

    @Override
    public Contractor findById(Long id) {
        return contractorRepository.getOne(id);
    }

    @Override
    public List<Contractor> findAll() {
        return contractorRepository.findAll();
    }

    @Override
    public Contractor create(Contractor contractor) {
        return contractorRepository.save(contractor);
    }

    @Override
    public Contractor update(Contractor contractor) {
        return contractorRepository.save(contractor);
    }

    @Override
    public void deleteById(Long id) {
        contractorRepository.deleteById(id);
    }
}
