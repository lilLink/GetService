package com.shtukary.GetService.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "feedback")
public class ContractFeedback implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private Long contractFeedbackId;

    private double mark;

    private String comment;

    public ContractFeedback() {
    }

    public ContractFeedback(double mark, String comment) {
        this.mark = mark;
        this.comment = comment;
    }

    public Long getContractFeedbackId() {
        return contractFeedbackId;
    }

    public void setContractFeedbackId(Long contractFeedbackId) {
        this.contractFeedbackId = contractFeedbackId;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
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
        ContractFeedback that = (ContractFeedback) o;
        return Double.compare(that.mark, mark) == 0 &&
                Objects.equals(contractFeedbackId, that.contractFeedbackId) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractFeedbackId, mark, comment);
    }

    @Override
    public String toString() {
        return "ContractFeedback{" +
                "contractFeedbackId=" + contractFeedbackId +
                ", mark=" + mark +
                ", comment='" + comment + '\'' +
                '}';
    }
}
