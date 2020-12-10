package com.shtukary.GetService.service;

import com.shtukary.GetService.models.Skill;
import com.shtukary.GetService.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SkillService implements AbstractService<Skill>{

    private final SkillRepository skillRepository;

    @Autowired
    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public Skill findById(Long id) {
        return skillRepository.getOne(id);
    }

    @Override
    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    @Override
    public Skill create(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public Skill update(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public void deleteById(Long id) {
        skillRepository.deleteById(id);
    }
}
