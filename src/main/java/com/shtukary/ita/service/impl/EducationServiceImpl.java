package com.shtukary.ita.service.impl;

import com.shtukary.ita.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shtukary.ita.dao.EducationDao;
import com.shtukary.ita.model.Education;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EducationServiceImpl implements EducationService {

    private final EducationDao educationDao;

    @Autowired
    public EducationServiceImpl(EducationDao educationDao) {
        this.educationDao = educationDao;
    }

    @Override
    public Optional<Education> findById(Long id) {
        return educationDao.findById(id);
    }

    @Override
    public List<Education> findAll() {
        return educationDao.findAll();
    }

    @Override
    public Education save(Education education) {
        return educationDao.save(education);
    }

    @Override
    public Education update(Education education) {
        return educationDao.update(education);
    }

    @Override
    public void deleteById(Long id) {
        educationDao.deleteById(id);
    }

}
