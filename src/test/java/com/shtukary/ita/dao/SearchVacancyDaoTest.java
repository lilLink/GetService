package com.shtukary.ita.dao;

import com.shtukary.ita.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.shtukary.ita.dao.impl.search.SearchVacancyDao;
import com.shtukary.ita.dto.search.SearchRequestDto;
import com.shtukary.ita.dto.search.SearchVacancyResponseDto;
import com.shtukary.ita.model.enumtype.Status;
import com.shtukary.ita.model.profile.Address;
import com.shtukary.ita.model.profile.Contact;
import com.shtukary.ita.model.profile.Person;
import com.shtukary.ita.model.profile.Photo;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchVacancyDaoTest {

    private SessionFactory sessionFactory;

    @BeforeEach
    void setUp() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Contact.class)
                .addAnnotatedClass(Photo.class)
                .addAnnotatedClass(Resume.class)
                .addAnnotatedClass(Job.class)
                .addAnnotatedClass(Skill.class)
                .addAnnotatedClass(Education.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Role.class)
                .addAnnotatedClass(Claim.class)
                .addAnnotatedClass(Company.class)
                .addAnnotatedClass(Requirement.class)
                .addAnnotatedClass(Status.class)
                .addAnnotatedClass(Vacancy.class)
                .addAnnotatedClass(VerificationToken.class)
                .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
                .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/rabotyNET")
                .setProperty("hibernate.connection.username", "postgres")
                .setProperty("hibernate.connection.password", "root")
                .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .buildSessionFactory();
    }

    @Test
    void getResponse() {
        SearchRequestDto searchRequestDto = new SearchRequestDto();
        searchRequestDto.setSearchParameter("position");
        searchRequestDto.setSearchText("Java ");
        searchRequestDto.setFirstResultNumber(0);
        searchRequestDto.setResultsOnPage(5000);
        searchRequestDto.setDirection("asc");
        searchRequestDto.setSearchSort("position");
        SearchVacancyDao searchVacancyDao = new SearchVacancyDao(sessionFactory);
        SearchVacancyResponseDto searchVacancyResponseDto = searchVacancyDao.getResponse(searchRequestDto);
        assertEquals(searchVacancyResponseDto.getCount().intValue(), searchVacancyResponseDto.getSearchVacancyDtos().size());
    }

}
