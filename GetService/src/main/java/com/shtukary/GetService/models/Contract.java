package com.shtukary.GetService.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "contract")
public class Contract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Long contractId;

    @OneToMany(mappedBy = "contract", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Employer> employers;

    private float price;

    private String description;

    @OneToMany(mappedBy = "contract", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Skill> neededSkill;

    public Contract() {
    }

    public Contract(List<Employer> employers, float price, String description, List<Skill> neededSkill) {
        this.employers = employers;
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

    public List<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(List<Employer> employers) {
        this.employers = employers;
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

    public List<Skill> getNeededSkill() {
        return neededSkill;
    }

    public void setNeededSkill(List<Skill> neededSkill) {
        this.neededSkill = neededSkill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return Float.compare(contract.price, price) == 0 &&
                Objects.equals(contractId, contract.contractId) &&
                Objects.equals(employers, contract.employers) &&
                Objects.equals(description, contract.description) &&
                Objects.equals(neededSkill, contract.neededSkill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractId, employers, price, description, neededSkill);
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractId=" + contractId +
                ", employers=" + employers +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", neededSkill=" + neededSkill +
                '}';
    }
}
