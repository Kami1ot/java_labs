package com.example.p_spring_53.repository;

import com.example.p_spring_53.model.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculationRepository extends JpaRepository<Calculation, Long> {}
