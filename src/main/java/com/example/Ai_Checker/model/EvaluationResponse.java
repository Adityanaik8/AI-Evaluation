package com.example.Ai_Checker.model;

public class EvaluationResponse {

    private int score;
    private String feedback;

    public EvaluationResponse(int score, String feedback) {
        this.score = score;
        this.feedback = feedback;
    }

    public int getScore() {
        return score;
    }

    public String getFeedback() {
        return feedback;
    }
}
