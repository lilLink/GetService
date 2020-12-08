package com.shtukary.ita.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.shtukary.ita.model.profile.Contact;

@Getter
@Setter
@NoArgsConstructor
public class PersonDto {

    private Long userId;

    private String firstName;

    private String lastName;

    private Contact contact;

}
