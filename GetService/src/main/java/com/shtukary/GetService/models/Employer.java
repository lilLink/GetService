package com.shtukary.GetService.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employer")
public class Employer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employerId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    @NotNull
    private User user;

    @OneToMany(mappedBy = "employer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<PendingContract> pendingContracts;

    @OneToMany(mappedBy = "employer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CurrentContract> currentContracts;

    @OneToMany(mappedBy = "employer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<FinishedContract> finishedContracts;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "contract_id", nullable = false)
    private Contract contract;

    public Employer() {
    }

    public Long getEmployerId() {
        return employerId;
    }

    public void setEmployerId(Long employerId) {
        this.employerId = employerId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<PendingContract> getPendingContracts() {
        return pendingContracts;
    }

    public void setPendingContracts(List<PendingContract> pendingContracts) {
        this.pendingContracts = pendingContracts;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employer employer = (Employer) o;
        return Objects.equals(employerId, employer.employerId) &&
                Objects.equals(user, employer.user) &&
                Objects.equals(pendingContracts, employer.pendingContracts) &&
                Objects.equals(currentContracts, employer.currentContracts) &&
                Objects.equals(finishedContracts, employer.finishedContracts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employerId, user, pendingContracts, currentContracts, finishedContracts);
    }

    @Override
    public String toString() {
        return "Employer{" +
                "employerId=" + employerId +
                ", user=" + user +
                ", pendingContracts=" + pendingContracts +
                ", currentContracts=" + currentContracts +
                ", finishedContracts=" + finishedContracts +
                '}';
    }

}
