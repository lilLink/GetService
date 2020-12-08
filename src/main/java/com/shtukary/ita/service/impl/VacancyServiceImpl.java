package com.shtukary.ita.service.impl;

import com.shtukary.ita.service.ResumeService;
import com.shtukary.ita.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shtukary.ita.dao.CompanyDao;
import com.shtukary.ita.dao.RequirementDao;
import com.shtukary.ita.dao.VacancyDao;
import com.shtukary.ita.dto.VacancyDto;
import com.shtukary.ita.exception.ResourceNotFoundException;
import com.shtukary.ita.model.Company;
import com.shtukary.ita.model.Requirement;
import com.shtukary.ita.model.Resume;
import com.shtukary.ita.model.Vacancy;
import com.shtukary.ita.model.enumtype.VacancyStatus;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.shtukary.ita.utility.LoggedUserUtil.getLoggedUser;

@Service
@Transactional
public class VacancyServiceImpl implements VacancyService {

    private static final int COUNT_VACANCIES_ON_SINGLE_PAGE = 9;
    private static final int COUNT_VACANCIES_ON_VIEW_COMPANY_PAGE = 4;

    private final VacancyDao vacancyDao;
    private final RequirementDao requirementDao;
    private final CompanyDao companyDao;

    private final ResumeService resumeService;

    @Autowired
    public VacancyServiceImpl(VacancyDao vacancyDao, RequirementDao requirementDao, CompanyDao companyDao, ResumeService resumeService) {
        this.vacancyDao = vacancyDao;
        this.requirementDao = requirementDao;
        this.companyDao = companyDao;
        this.resumeService = resumeService;
    }

    @Override
    public Optional<Vacancy> findById(Long id) {
        return vacancyDao.findById(id);
    }

    @Override
    public List<Vacancy> findAll() {
        return vacancyDao.findAll();
    }

    @Override
    public VacancyDto findAllVacanciesByCompanyId(Long companyId, int first) {
        return new VacancyDto(vacancyDao.getCountOfVacanciesByCompanyId(companyId),
                vacancyDao.findAllByCompanyIdWithPagination(companyId, first, COUNT_VACANCIES_ON_VIEW_COMPANY_PAGE));
    }

    @Override
    public VacancyDto findAllHotVacanciesWithPagination(int first) {
        return new VacancyDto(vacancyDao.getCountAllHotVacancies(),
                vacancyDao.findAllHotVacanciesWithPagination(first, COUNT_VACANCIES_ON_SINGLE_PAGE));
    }

    @Override
    public VacancyDto findAllClosedVacanciesWithPagination(int first) {
        return new VacancyDto(vacancyDao.getCountAllClosedVacancies(),
                vacancyDao.findAllClosedVacanciesWithPagination(first, COUNT_VACANCIES_ON_SINGLE_PAGE));
    }

    @Override
    public VacancyDto findAllVacanciesWithPagination(int first) {
        return new VacancyDto(vacancyDao.getCountOfAllVacancies(),
                vacancyDao.findAllVacanciesWithPagination(first, COUNT_VACANCIES_ON_SINGLE_PAGE));
    }

    @Override
    public Vacancy save(Vacancy vacancy, Long companyId) {
        Company company = companyDao.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with id " + companyId));
        vacancy.setCompany(company);

        Set<Requirement> requirements = vacancy.getRequirements();
        requirements.forEach(e -> e.setVacancy(vacancy));
        vacancy.setVacancyStatus(VacancyStatus.OPEN);
        vacancyDao.save(vacancy);
        requirements.forEach(requirementDao::save);

        return vacancyDao.save(vacancy);
    }

    @Override
    public Vacancy update(Vacancy vacancy) {
        Company company = companyDao.findByVacancyId(vacancy.getVacancyId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Company by vacancy id: %d not found", vacancy.getVacancyId())));

        if (company.getUser().getUserId().equals(getLoggedUser().get().getUserId())) {
            vacancy.setCompany(company);
            Set<Requirement> requirements = vacancy.getRequirements();
            requirements.forEach(e -> e.setVacancy(vacancy));
            requirements.stream().filter(requirement -> requirement.getRequirementId() == null).forEach(requirementDao::save);
            requirements.forEach(requirementDao::update);

            Set<Resume> resumes = vacancyDao.findById(vacancy.getVacancyId()).get().getResumes();
            vacancy.setResumes(resumes);
            resumes.forEach(resumeService::update);
        }

        return vacancyDao.update(vacancy);
    }

    @Override
    public void deleteById(Long id) {
        Company company = companyDao.findByVacancyId(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Company by vacancy id: %d not found", id)));

        if (company.getUser().getUserId().equals(getLoggedUser().get().getUserId())) {
            vacancyDao.deleteById(id);
        }
    }

}
