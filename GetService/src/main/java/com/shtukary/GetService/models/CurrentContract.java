package com.shtukary.GetService.models;

import javax.persistence.*;

@Entity
@Table(name = "current")
public class CurrentContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "current_id")
    private Long contractId;

    private Contractor contractor;

    private Employer employer;
}
