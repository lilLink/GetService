package com.shtukary.GetService.repos;

import com.shtukary.GetService.models.StartedContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StartedContractRepository extends JpaRepository<StartedContract, Long> {
}
