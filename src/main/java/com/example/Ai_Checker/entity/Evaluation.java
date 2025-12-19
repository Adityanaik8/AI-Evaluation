package com.example.Ai_Checker.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "evaluations")
@Data
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000)
    private String modelAnswer;

    @Column(length = 1000)
    private String studentAnswer;

    private int keywordMatch;

    private int similarity;

    private int score;

    private String feedback;
}
