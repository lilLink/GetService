package com.shukary.GetService.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employer")
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employer_id")
    private Long employerId;

    private User user;

    private List<PendingContract> pendingContracts;

    private List<CurrentContract> currentContracts;

    private List<FinishedContract> finishedContracts;

}
