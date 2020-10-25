package com.shtukary.GetService.repos;

import com.shtukary.GetService.models.CurrentContract;
import org.springframework.data.repository.CrudRepository;

public interface CurrentContactRepository extends CrudRepository<CurrentContract, Long> {
}
