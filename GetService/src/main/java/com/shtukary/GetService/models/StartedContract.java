package com.shtukary.GetService.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "started")
public class StartedContract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "started_id")
    private Long startedContractId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contract_id", referencedColumnName = "contract_id", nullable = false)
    private Contract contract;

    @OneToMany(mappedBy = "startedContract", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Contractor> contractors;

    public StartedContract() {
    }

    public StartedContract(Contract contract, List<Contractor> contractors) {
        this.contract = contract;
        this.contractors = contractors;
    }

    public Long getStartedContractId() {
        return startedContractId;
    }

    public void setStartedContractId(Long startedContractId) {
        this.startedContractId = startedContractId;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public List<Contractor> getContractors() {
        return contractors;
    }

    public void setContractors(List<Contractor> contractors) {
        this.contractors = contractors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StartedContract that = (StartedContract) o;
        return Objects.equals(startedContractId, that.startedContractId) &&
                Objects.equals(contract, that.contract) &&
                Objects.equals(contractors, that.contractors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startedContractId, contract, contractors);
    }

    @Override
    public String toString() {
        return "StartedContract{" +
                "startedContractId=" + startedContractId +
                ", contract=" + contract +
                ", contractors=" + contractors +
                '}';
    }
}
