package com.shtukary.ita.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.shtukary.ita.model.Resume;

@Getter
@Setter
@NoArgsConstructor
public class SkillDto {

    private Long skillId;

    private String title;

    private String description;

    private Resume resume;

}
