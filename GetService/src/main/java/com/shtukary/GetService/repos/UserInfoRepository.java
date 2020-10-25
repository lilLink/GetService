package com.shtukary.GetService.repos;

import com.shtukary.GetService.models.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {
}
