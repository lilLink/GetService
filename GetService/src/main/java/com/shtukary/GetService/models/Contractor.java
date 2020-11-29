package com.shtukary.GetService.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "contractor")
public class Contractor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractorId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contractor_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "contractor",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CurrentContract> currentContracts;

    @OneToMany(mappedBy = "contractor",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<FinishedContract> finishedContract;

    @OneToMany(mappedBy = "contractor",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Skill> skills;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "started_id", nullable = false)
    private StartedContract startedContract;

    public Contractor() {
    }

    public Contractor(User user, List<CurrentContract> currentContracts, List<FinishedContract> finishedContract, List<Skill> skills) {
        this.user = user;
        this.currentContracts = currentContracts;
        this.finishedContract = finishedContract;
        this.skills = skills;
    }

    public Long getContractorId() {
        return contractorId;
    }

    public void setContractorId(Long contractorId) {
        this.contractorId = contractorId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CurrentContract> getCurrentContracts() {
        return currentContracts;
    }

    public void setCurrentContracts(List<CurrentContract> currentContracts) {
        this.currentContracts = currentContracts;
    }

    public List<FinishedContract> getFinishedContracts() {
        return finishedContract;
    }

    public void setFinishedContracts(List<FinishedContract> finishedContract) {
        this.finishedContract = finishedContract;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contractor that = (Contractor) o;
        return Objects.equals(contractorId, that.contractorId) &&
                Objects.equals(user, that.user) &&
                Objects.equals(currentContracts, that.currentContracts) &&
                Objects.equals(finishedContract, that.finishedContract) &&
                Objects.equals(skills, that.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractorId, user, currentContracts, finishedContract, skills);
    }

    @Override
    public String toString() {
        return "Contractor{" +
                "contractorId=" + contractorId +
                ", user=" + user +
                ", currentContracts=" + currentContracts +
                ", finishedContracts=" + finishedContract +
                ", skills=" + skills +
                '}';
    }
}
