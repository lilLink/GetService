package com.shtukary.ita.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.shtukary.ita.model.Resume;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class JobDto {

    private Long jobId;

    private String position;

    private LocalDate begin;

    private LocalDate end;

    private String companyName;

    private String description;

    private Resume resume;

}
