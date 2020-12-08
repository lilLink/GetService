package com.shtukary.ita.service.impl;

import com.shtukary.ita.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shtukary.ita.dao.SkillDao;
import com.shtukary.ita.model.Skill;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SkillServiceImpl implements SkillService {

    private final SkillDao skillDao;

    @Autowired
    public SkillServiceImpl(SkillDao skillDao) {
        this.skillDao = skillDao;
    }

    @Override
    public Optional<Skill> findById(Long id) {
        return skillDao.findById(id);
    }

    @Override
    public List<Skill> findAll() {
        return skillDao.findAll();
    }

    @Override
    public Skill save(Skill skill) {
        return skillDao.save(skill);
    }

    @Override
    public Skill update(Skill skill) {
        return skillDao.update(skill);
    }

    @Override
    public void deleteById(Long id) {
        skillDao.deleteById(id);
    }

}
