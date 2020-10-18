package com.shtukary.GetService.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "contractor")
public class Contractor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contractor_id")
    private Long contractorId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contractor_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "contractors")
    private List<CurrentContract> currentContracts;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "contractor_id", nullable = false)
    private List<FinishedContract> finishedContracts;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "contractors")
    private List<Skill> skills;

    public Contractor() {
    }

    public Contractor(User user, List<CurrentContract> currentContracts, List<FinishedContract> finishedContracts, List<Skill> skills) {
        this.user = user;
        this.currentContracts = currentContracts;
        this.finishedContracts = finishedContracts;
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
        return finishedContracts;
    }

    public void setFinishedContracts(List<FinishedContract> finishedContracts) {
        this.finishedContracts = finishedContracts;
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
                Objects.equals(finishedContracts, that.finishedContracts) &&
                Objects.equals(skills, that.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractorId, user, currentContracts, finishedContracts, skills);
    }

    @Override
    public String toString() {
        return "Contractor{" +
                "contractorId=" + contractorId +
                ", user=" + user +
                ", currentContracts=" + currentContracts +
                ", finishedContracts=" + finishedContracts +
                ", skills=" + skills +
                '}';
    }
}
