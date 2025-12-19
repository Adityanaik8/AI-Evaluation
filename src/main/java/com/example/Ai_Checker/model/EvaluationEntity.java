package com.example.Ai_Checker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "evaluations")
public class EvaluationEntity {

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

    public Long getId() { return id; }

    public String getModelAnswer() { return modelAnswer; }
    public void setModelAnswer(String modelAnswer) { this.modelAnswer = modelAnswer; }

    public String getStudentAnswer() { return studentAnswer; }
    public void setStudentAnswer(String studentAnswer) { this.studentAnswer = studentAnswer; }

    public int getKeywordMatch() { return keywordMatch; }
    public void setKeywordMatch(int keywordMatch) { this.keywordMatch = keywordMatch; }

    public int getSimilarity() { return similarity; }
    public void setSimilarity(int similarity) { this.similarity = similarity; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }
}
