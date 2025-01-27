package com.example.p_spring_53.service;

import com.example.p_spring_53.model.Calculation;
import com.example.p_spring_53.repository.CalculationRepository;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private final CalculationRepository repository;

    public CalculatorService(CalculationRepository repository) {
        this.repository = repository;
    }

    public Calculation calculate(String operation, double operand1, double operand2) {
        double result;
        switch (operation) {
            case "+" -> result = operand1 + operand2;
            case "-" -> result = operand1 - operand2;
            case "*" -> result = operand1 * operand2;
            case "/" -> {
                if (operand2 == 0) throw new ArithmeticException("Деление на ноль запрещено.");
                result = operand1 / operand2;
            }
            default -> throw new IllegalArgumentException("Недопустимая операция.");
        }

        Calculation calculation = new Calculation(operation, operand1, operand2, result);
        return repository.save(calculation);
    }

    public Iterable<Calculation> getAllCalculations() {
        return repository.findAll();
    }
}
