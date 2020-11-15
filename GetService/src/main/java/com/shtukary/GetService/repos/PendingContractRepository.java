package com.shtukary.GetService.repos;

import com.shtukary.GetService.models.PendingContract;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PendingContractRepository extends CrudRepository<PendingContract, Long> {
}
