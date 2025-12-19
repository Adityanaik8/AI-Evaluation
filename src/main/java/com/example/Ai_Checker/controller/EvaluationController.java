package com.example.Ai_Checker.controller;

import com.example.Ai_Checker.service.AnswerEvaluationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evaluate")
public class EvaluationController {

    private final AnswerEvaluationService service;

    public EvaluationController(AnswerEvaluationService service) {
        this.service = service;
    }

    @PostMapping
    public double evaluate(@RequestParam String studentAnswer) {

        String modelAnswer = "Java is an object oriented programming language used to build applications";

        return service.evaluate(studentAnswer, modelAnswer);
    }
}
