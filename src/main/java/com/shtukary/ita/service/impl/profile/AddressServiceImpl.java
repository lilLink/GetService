package com.shtukary.ita.service.impl.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shtukary.ita.dao.AddressDao;
import com.shtukary.ita.model.profile.Address;
import com.shtukary.ita.service.AddressService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    private final AddressDao addressDao;

    @Autowired
    public AddressServiceImpl(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public Optional<Address> findById(Long id) {
        return addressDao.findById(id);
    }

    @Override
    public List<Address> findAll() {
        return addressDao.findAll();
    }

    @Override
    public Address save(Address vacancy) {
        return addressDao.save(vacancy);
    }

    @Override
    public Address update(Address address) {
        return addressDao.update(address);
    }

    @Override
    public void deleteById(Long id) {
        addressDao.deleteById(id);
    }

}
