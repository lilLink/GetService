package com.shtukary.ita.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.shtukary.ita.model.Resume;

@Getter
@Setter
@NoArgsConstructor
public class EducationDto {

    private Long educationId;

    private String degree;

    private String school;

    private String specialty;

    private Integer graduation;

    private Resume resume;

}
