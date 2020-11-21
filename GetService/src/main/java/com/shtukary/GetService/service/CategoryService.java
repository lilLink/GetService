package com.shtukary.GetService.service;

import com.shtukary.GetService.models.Category;
import com.shtukary.GetService.repos.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService implements AbstractService<Category> {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category findById(Long id) {
        return categoryRepository.getOne(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category create(Category category){
        return categoryRepository.save(category);
    }

}
