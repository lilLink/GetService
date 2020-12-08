package com.shtukary.ita.service.impl.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shtukary.ita.dao.ContactDao;
import com.shtukary.ita.model.profile.Contact;
import com.shtukary.ita.service.ContactService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

    private final ContactDao contactDao;

    @Autowired
    public ContactServiceImpl(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Override
    public Optional<Contact> findById(Long id) {
        return contactDao.findById(id);
    }

    @Override
    public List<Contact> findAll() {
        return contactDao.findAll();
    }

    @Override
    public Contact save(Contact contact) {
        return contactDao.save(contact);
    }

    @Override
    public Contact update(Contact contact) {
        return contactDao.update(contact);
    }

    @Override
    public void deleteById(Long id) {
        contactDao.deleteById(id);
    }

}
