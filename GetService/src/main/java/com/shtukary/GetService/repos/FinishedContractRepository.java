package com.shtukary.GetService.repos;

import com.shtukary.GetService.models.FinishedContract;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinishedContractRepository extends CrudRepository<FinishedContract, Long> {
}
