package com.example.p_spring_53.model;

import jakarta.persistence.*;

@Entity
public class Calculation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String operation;
    private double operand1;
    private double operand2;
    private double result;

    public Calculation() {}

    public Calculation(String operation, double operand1, double operand2, double result) {
        this.operation = operation;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = result;
    }

    public Long getId() { return id; }
    public String getOperation() { return operation; }
    public double getOperand1() { return operand1; }
    public double getOperand2() { return operand2; }
    public double getResult() { return result; }
}
