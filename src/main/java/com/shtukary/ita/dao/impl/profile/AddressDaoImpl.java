package com.shtukary.ita.dao.impl.profile;

import com.shtukary.ita.dao.AddressDao;
import com.shtukary.ita.dao.impl.AbstractDao;
import org.springframework.stereotype.Repository;
import com.shtukary.ita.model.profile.Address;

@Repository
public class AddressDaoImpl extends AbstractDao<Address, Long> implements AddressDao {
}
