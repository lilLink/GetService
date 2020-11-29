package com.shtukary.GetService.repos;

import com.shtukary.GetService.models.PendingContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PendingContractRepository extends JpaRepository<PendingContract, Long> {
}
