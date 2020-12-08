package com.shtukary.ita.dao.impl;

import com.shtukary.ita.dao.ResumeDao;
import com.shtukary.ita.utility.QueryUtility;
import org.springframework.stereotype.Repository;
import com.shtukary.ita.model.Resume;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class ResumeDaoImpl extends AbstractDao<Resume, Long> implements ResumeDao {

    private static final String ID = "id";

    @Override
    @SuppressWarnings("unchecked")
    public Optional<Resume> findByUserId(Long id) {
        return QueryUtility.findOrEmpty(() -> {
            Resume result = null;
            try {
                result = (Resume) createNamedQuery(Resume.FIND_BY_USER_ID)
                        .setParameter(ID, id)
                        .getSingleResult();
            } catch (NoResultException ex) {
                Logger.getLogger(ResumeDaoImpl.class.getName()).log(Level.WARNING, "Resume not found with name " + id);
            }

            return result;
        });
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Resume> findResumeByVacancyId(Long vacancyId) {
        return (List<Resume>) createNamedQuery(Resume.FIND_RESUME_BY_VACANCY_ID)
                .setParameter(ID, vacancyId)
                .getResultList();
    }

}
