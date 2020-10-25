package com.shtukary.GetService.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pending")
public class PendingContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pending_id")
    private Long contractId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employer_id", nullable = false)
    private Employer employer;

    @Column(name = "price")
    private float price;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill neededSkill;

    public PendingContract() {
    }

    public PendingContract(Employer employer, float price, String description, Skill neededSkill) {
        this.employer = employer;
        this.price = price;
        this.description = description;
        this.neededSkill = neededSkill;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Skill getNeededSkill() {
        return neededSkill;
    }

    public void setNeededSkill(Skill neededSkill) {
        this.neededSkill = neededSkill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PendingContract that = (PendingContract) o;
        return Float.compare(that.price, price) == 0 &&
                Objects.equals(contractId, that.contractId) &&
                Objects.equals(employer, that.employer) &&
                Objects.equals(description, that.description) &&
                Objects.equals(neededSkill, that.neededSkill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractId, employer, price, description, neededSkill);
    }

    @Override
    public String toString() {
        return "PendingContract{" +
                "contractId=" + contractId +
                ", employer=" + employer +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", neededSkill=" + neededSkill +
                '}';
    }
}
