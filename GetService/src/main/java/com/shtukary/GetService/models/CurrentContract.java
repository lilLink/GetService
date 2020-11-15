package com.shtukary.GetService.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "current")
public class CurrentContract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "current_id")
    private Long currentId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "started_id", referencedColumnName = "started_id")
    private StartedContract startedContract;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "contractor_id", nullable = false)
    private Contractor contractor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employer_id", nullable = false)
    private Employer employer;

    public CurrentContract() {
    }

    public CurrentContract(StartedContract startedContract) {
        this.startedContract = startedContract;
    }

    public Long getCurrentId() {
        return currentId;
    }

    public void setCurrentId(Long currentId) {
        this.currentId = currentId;
    }

    public StartedContract getStartedContract() {
        return startedContract;
    }

    public void setStartedContract(StartedContract startedContract) {
        this.startedContract = startedContract;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentContract that = (CurrentContract) o;
        return Objects.equals(currentId, that.currentId) &&
                Objects.equals(startedContract, that.startedContract);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentId, startedContract);
    }

    @Override
    public String toString() {
        return "CurrentContract{" +
                "currentId=" + currentId +
                ", startedContract=" + startedContract +
                '}';
    }
}
