package com.shtukary.GetService.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "finished")
public class FinishedContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "finished_id")
    private Long contractId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employer_id", nullable = false)
    private Employer employer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "contractor_id", nullable = false)
    private Contractor contractor;

    @Column(name = "mark")
    private float mark;

    @Column(name = "comment")
    private String comment;

    public FinishedContract() {
    }

    public FinishedContract(Employer employer, Contractor contractor, float mark, String comment) {
        this.employer = employer;
        this.contractor = contractor;
        this.mark = mark;
        this.comment = comment;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinishedContract that = (FinishedContract) o;
        return Float.compare(that.mark, mark) == 0 &&
                Objects.equals(contractId, that.contractId) &&
                Objects.equals(employer, that.employer) &&
                Objects.equals(contractor, that.contractor) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractId, employer, contractor, mark, comment);
    }

    @Override
    public String toString() {
        return "FinishedContract{" +
                "contractId=" + contractId +
                ", employer=" + employer +
                ", contractor=" + contractor +
                ", mark=" + mark +
                ", comment='" + comment + '\'' +
                '}';
    }
}
