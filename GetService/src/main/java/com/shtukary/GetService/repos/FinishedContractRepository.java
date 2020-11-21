package com.shtukary.GetService.repos;

import com.shtukary.GetService.models.FinishedContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinishedContractRepository extends JpaRepository<FinishedContract, Long> {
}
