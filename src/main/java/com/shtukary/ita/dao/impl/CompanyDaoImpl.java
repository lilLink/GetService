package com.shtukary.ita.dao.impl;

import com.shtukary.ita.dao.CompanyDao;
import com.shtukary.ita.utility.QueryUtility;
import org.springframework.stereotype.Repository;
import com.shtukary.ita.model.Company;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class CompanyDaoImpl extends AbstractDao<Company, Long> implements CompanyDao {

    private static final String ID = "id";
    private static final String NAME = "name";

    @Override
    public Optional<Company> findByVacancyId(Long id) {
        return QueryUtility.findOrEmpty(() -> ((Company) createNamedQuery(Company.FIND_BY_VACANCY_ID)
                .setParameter(ID, id)
                .getSingleResult()));
    }

    @Override
    public Long getCompaniesCount() {
        return (Long) createNamedQuery(Company.FIND_COUNT_COMPANY)
                .getSingleResult();
    }

    @Override
    public Optional<Company> findByName(String name) {
        return QueryUtility.findOrEmpty(() -> {
            Company result = null;
            try {
                result = (Company) createNamedQuery(Company.FIND_BY_COMPANY_NAME)
                        .setParameter(NAME, name)
                        .getSingleResult();
            } catch (NoResultException ex) {
                Logger.getLogger(CompanyDaoImpl.class.getName()).log(Level.WARNING, "Company not found with name " + name);
            }

            return result;
        });
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Company> findByUserId(Long id) {
        return (List<Company>) createNamedQuery(Company.FIND_BY_USER_ID)
                .setParameter(ID, id)
                .getResultList();
    }

}
