package com.shtukary.GetService.service;

import com.shtukary.GetService.models.UserInfo;
import com.shtukary.GetService.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserInfoService implements AbstractService<UserInfo> {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findById(Long id) {
        return userInfoRepository.getOne(id);
    }

    @Override
    public List<UserInfo> findAll() {
        return userInfoRepository.findAll();
    }

    @Override
    public UserInfo create(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }

    @Override
    public UserInfo update(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }

    @Override
    public void deleteById(Long id) {
        userInfoRepository.deleteById(id);
    }
}
