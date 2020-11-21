package com.shtukary.GetService.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pending")
public class PendingContract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contract_id", referencedColumnName = "contract_id", nullable = false)
    private Contract contract;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employer_id", nullable = false)
    private Employer employer;

    public PendingContract() {
    }

    public PendingContract(Contract contract) {
        this.contract = contract;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PendingContract that = (PendingContract) o;
        return Objects.equals(contractId, that.contractId) &&
                Objects.equals(contract, that.contract);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractId, contract);
    }

    @Override
    public String toString() {
        return "PendingContract{" +
                "contractId=" + contractId +
                ", contract=" + contract +
                '}';
    }
}
