package com.shtukary.ita.dao.impl;

import com.shtukary.ita.dao.JobDao;
import org.springframework.stereotype.Repository;
import com.shtukary.ita.model.Job;

@Repository
public class JobDaoImpl extends AbstractDao<Job, Long> implements JobDao {
}
