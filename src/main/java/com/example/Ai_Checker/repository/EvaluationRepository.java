package com.example.Ai_Checker.repository;

import com.example.Ai_Checker.model.EvaluationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepository extends JpaRepository<EvaluationEntity, Long> {
}
