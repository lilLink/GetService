package com.shtukary.GetService.repos;

import com.shtukary.GetService.models.StartedContract;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StartedContractRepository extends CrudRepository<StartedContract, Long> {
}
