package com.shtukary.GetService.repos;

import com.shtukary.GetService.models.CurrentContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentContactRepository extends JpaRepository<CurrentContract, Long> {
}
