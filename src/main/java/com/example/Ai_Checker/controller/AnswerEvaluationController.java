package com.example.Ai_Checker.controller;

import java.util.List;

import com.example.Ai_Checker.model.AnswerRequest;
import com.example.Ai_Checker.model.EvaluationEntity;
import com.example.Ai_Checker.model.EvaluationResponse;
import com.example.Ai_Checker.service.EvaluationService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AnswerEvaluationController {

    private final EvaluationService evaluationService;

    public AnswerEvaluationController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }
    @PostMapping("/evaluate")
    public EvaluationResponse evaluateAnswer(@RequestBody AnswerRequest request) {
        return evaluationService.evaluate(request);
    }
    @GetMapping("/test")
    public String test() {
        return "AI Answer Evaluation System is running!";
    }
    @GetMapping("/history")
    public List<EvaluationEntity> getHistory() {
        return evaluationService.getAllEvaluations();
    }
}
