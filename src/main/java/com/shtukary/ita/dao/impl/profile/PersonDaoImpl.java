package com.shtukary.ita.dao.impl.profile;

import com.shtukary.ita.dao.PersonDao;
import com.shtukary.ita.dao.impl.AbstractDao;
import org.springframework.stereotype.Repository;
import com.shtukary.ita.model.profile.Person;

@Repository
public class PersonDaoImpl extends AbstractDao<Person, Long> implements PersonDao {
}
