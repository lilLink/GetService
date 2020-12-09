package com.shtukary.GetService.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Long contractId;

    @OneToMany(mappedBy = "contract", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Employer> employers;

    @Column(name = "price")
    private Long price;

    @Column(name = "description")
    private String description;

    @Column(name = "skill")
    private List<String> neededSkills;

    @OneToMany(mappedBy = "contract", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;
}
