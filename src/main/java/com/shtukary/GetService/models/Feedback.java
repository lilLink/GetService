package com.shtukary.GetService.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private Long feedbackId;

    @Column(name = "comment")
    private String comment;
}
