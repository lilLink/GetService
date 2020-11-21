package com.shtukary.GetService.repos;

import com.shtukary.GetService.models.ContractFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractFeedbackRepository extends JpaRepository<ContractFeedback, Long> {
}
