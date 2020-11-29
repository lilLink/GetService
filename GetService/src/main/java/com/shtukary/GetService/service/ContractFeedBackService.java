package com.shtukary.GetService.service;

import com.shtukary.GetService.models.ContractFeedback;
import com.shtukary.GetService.repos.ContractFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContractFeedBackService implements AbstractService<ContractFeedback> {

    @Autowired
    private ContractFeedbackRepository contractFeedbackRepository;

    @Override
    public ContractFeedback findById(Long id) {
        return contractFeedbackRepository.getOne(id);
    }

    @Override
    public List<ContractFeedback> findAll() {
        return contractFeedbackRepository.findAll();
    }

    @Override
    public ContractFeedback create(ContractFeedback contractFeedback) {
        return contractFeedbackRepository.save(contractFeedback);
    }

    @Override
    public ContractFeedback update(ContractFeedback contractFeedback) {
        return contractFeedbackRepository.save(contractFeedback);
    }

    @Override
    public void deleteById(Long id) {
        contractFeedbackRepository.deleteById(id);
    }
}
