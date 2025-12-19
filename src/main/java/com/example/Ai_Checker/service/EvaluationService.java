package com.example.Ai_Checker.service;
import java.util.List;
import com.example.Ai_Checker.model.*;
import com.example.Ai_Checker.repository.EvaluationRepository;
import com.example.Ai_Checker.model.EvaluationResponse;

import org.springframework.stereotype.Service;

@Service
public class EvaluationService {

    private final EvaluationRepository repository;

    public EvaluationService(EvaluationRepository repository) {
        this.repository = repository;
    }

    public EvaluationResponse evaluate(AnswerRequest request) {

        String modelAnswer = request.getModelAnswer().toLowerCase();
        String studentAnswer = request.getStudentAnswer().toLowerCase();

        String[] modelWords = modelAnswer.split("\\s+");

        int matchedWords = 0;
        for (String word : modelWords) {
            if (studentAnswer.contains(word)) {
                matchedWords++;
            }
        }

        int similarity = (int) ((matchedWords * 100.0) / modelWords.length);
        int score = (int) Math.round((similarity / 100.0) * 10);

        String feedback;
        if (score >= 7) {
            feedback = "Good answer";
        } else if (score >= 4) {
            feedback = "Average answer";
        } else {
            feedback = "Needs improvement";
        }

        EvaluationEntity entity = new EvaluationEntity();
        entity.setModelAnswer(request.getModelAnswer());
        entity.setStudentAnswer(request.getStudentAnswer());
        entity.setKeywordMatch(matchedWords);
        entity.setSimilarity(similarity);
        entity.setScore(score);
        entity.setFeedback(feedback);

        repository.save(entity);

        return new EvaluationResponse(score, feedback);

    }

    public List<EvaluationEntity> getAllEvaluations() {
        return repository.findAll();
    }

}
