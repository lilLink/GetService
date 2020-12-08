package com.shtukary.ita.service.impl.profile;

import com.shtukary.ita.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shtukary.ita.dao.PersonDao;
import com.shtukary.ita.dao.UserDao;
import com.shtukary.ita.exception.ResourceNotFoundException;
import com.shtukary.ita.model.User;
import com.shtukary.ita.model.profile.Person;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static com.shtukary.ita.utility.LoggedUserUtil.getLoggedUser;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;
    private final UserDao userDao;

    @Autowired
    public PersonServiceImpl(PersonDao personDao, UserDao userDao) {
        this.personDao = personDao;
        this.userDao = userDao;
    }

    @Override
    public Optional<Person> findById(Long id) {
        if (getLoggedUser().isPresent()) {
            Long loggedUserId = getLoggedUser().get().getUserId();
            if (id.equals(loggedUserId)) {
                return personDao.findById(loggedUserId);
            }
        }

        throw new ResourceNotFoundException(String.format("Person with id %d was not found?!", id));
    }

    @Override
    public List<Person> findAll() {
        return personDao.findAll();
    }

    @Override
    public Person save(Person person) {
        return personDao.save(person);
    }

    @Override
    public Person update(Person person) {
        if (getLoggedUser().isPresent()) {
            Long loggedUserId = getLoggedUser().get().getUserId();
            if (person.getUserId().equals(loggedUserId)) {
                User user = userDao.findById(loggedUserId)
                        .orElseThrow(() -> new ResourceNotFoundException(String.format("User with id %d was not found?!", loggedUserId)));
                person.setUser(user);
            }
        }

        return personDao.update(person);
    }

    @Override
    public void deleteById(Long id) {
        personDao.deleteById(id);
    }

}
