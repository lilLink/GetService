package com.shtukary.GetService.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "finished")
public class FinishedContract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "finished_id")
    private Long contractId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "started_id", referencedColumnName = "started_id", nullable = false)
    private StartedContract startedContract;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "feedback_id", referencedColumnName = "feedback_id", nullable = false)
    private ContractFeedback contractFeedback;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "contractor_id", nullable = false)
    private Contractor contractor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employer_id", nullable = false)
    private Employer employer;

    public FinishedContract() {
    }

    public FinishedContract(StartedContract startedContract, ContractFeedback contractFeedback) {
        this.startedContract = startedContract;
        this.contractFeedback = contractFeedback;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public StartedContract getStartedContract() {
        return startedContract;
    }

    public void setStartedContract(StartedContract startedContract) {
        this.startedContract = startedContract;
    }

    public ContractFeedback getContractFeedback() {
        return contractFeedback;
    }

    public void setContractFeedback(ContractFeedback contractFeedback) {
        this.contractFeedback = contractFeedback;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinishedContract that = (FinishedContract) o;
        return Objects.equals(contractId, that.contractId) &&
                Objects.equals(startedContract, that.startedContract) &&
                Objects.equals(contractFeedback, that.contractFeedback);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractId, startedContract, contractFeedback);
    }

    @Override
    public String toString() {
        return "FinishedContract{" +
                "contractId=" + contractId +
                ", startedContract=" + startedContract +
                ", contractFeedback=" + contractFeedback +
                '}';
    }
}
