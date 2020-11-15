package com.shtukary.GetService.repos;

import com.shtukary.GetService.models.ContractFeedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractFeedbackRepository extends CrudRepository<ContractFeedback, Long> {
}
