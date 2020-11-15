package com.shtukary.GetService.repos;

import com.shtukary.GetService.models.CurrentContract;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentContactRepository extends CrudRepository<CurrentContract, Long> {
}
