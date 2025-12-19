package com.example.Ai_Checker.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnswerEvaluationService {

    public double evaluate(String studentAnswer, String modelAnswer) {

        double keywordScore = keywordMatch(studentAnswer, modelAnswer);
        double similarityScore = similarity(studentAnswer, modelAnswer);
        double lengthScore = lengthCheck(studentAnswer, modelAnswer);

        return (keywordScore * 0.4)
                + (similarityScore * 0.4)
                + (lengthScore * 0.2);
    }

    private double keywordMatch(String student, String model) {
        String[] keywords = model.toLowerCase().split(" ");
        int matchCount = 0;

        for (String word : keywords) {
            if (student.toLowerCase().contains(word)) {
                matchCount++;
            }
        }
        return (double) matchCount / keywords.length * 100;
    }

    private double similarity(String s1, String s2) {
        Set<String> set1 = new HashSet<>(Arrays.asList(s1.toLowerCase().split(" ")));
        Set<String> set2 = new HashSet<>(Arrays.asList(s2.toLowerCase().split(" ")));

        set1.retainAll(set2);
        return (double) set1.size() / set2.size() * 100;
    }

    private double lengthCheck(String student, String model) {
        return Math.min(
                (double) student.length() / model.length() * 100,
                100
        );
    }
}
