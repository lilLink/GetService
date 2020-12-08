package com.shtukary.ita.dao.impl;

import com.shtukary.ita.dao.ClaimDao;
import org.springframework.stereotype.Repository;
import com.shtukary.ita.model.Claim;

import java.util.List;

@Repository
public class ClaimDaoImpl extends AbstractDao<Claim, Long> implements ClaimDao {

    private static final String ID = "id";

    @Override
    @SuppressWarnings("unchecked")
    public List<Claim> findAllByCompanyId(Long id) {
        return (List<Claim>) createNamedQuery(Claim.FIND_BY_COMPANY_ID)
                .setParameter(ID, id)
                .getResultList();
    }

}
