package com.shtukary.ita.dao.impl.profile;

import com.shtukary.ita.dao.ContactDao;
import com.shtukary.ita.dao.impl.AbstractDao;
import org.springframework.stereotype.Repository;
import com.shtukary.ita.model.profile.Contact;

@Repository
public class ContactDaoImpl extends AbstractDao<Contact, Long> implements ContactDao {
}
