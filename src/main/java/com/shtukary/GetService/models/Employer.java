package com.shtukary.GetService.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employer")
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employerId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "contract_id")
    private Contract contract;
}
