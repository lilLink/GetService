package com.shtukary.ita.dao.impl;

import com.shtukary.ita.dao.RequirementDao;
import org.springframework.stereotype.Repository;
import com.shtukary.ita.model.Requirement;

@Repository
public class RequirementDaoImpl extends AbstractDao<Requirement, Long> implements RequirementDao {
}
