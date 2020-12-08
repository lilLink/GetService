package com.shtukary.ita.dto.company;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.shtukary.ita.model.User;
import com.shtukary.ita.model.Vacancy;
import com.shtukary.ita.model.enumtype.Status;
import com.shtukary.ita.model.profile.Address;
import com.shtukary.ita.model.profile.Contact;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CompanyDto {

    private Long companyId;

    private String name;

    private String edrpou;

    private String description;

    private String website;

    private Status status;

    private Contact contact;

    private Address address;

    private String logo;

    private Set<Vacancy> vacancies;

    private User user;

}
