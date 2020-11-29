package com.shtukary.GetService.service;

import java.util.List;
import java.util.Optional;

public interface AbstractService<Entity> {

    Entity findById(Long id);

    List<Entity> findAll();

    Entity create(Entity entity);

    Entity update(Entity entity);

    void deleteById(Long id);

}
