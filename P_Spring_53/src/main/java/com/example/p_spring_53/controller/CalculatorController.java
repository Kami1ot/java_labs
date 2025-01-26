package com.example.p_spring_53.controller;
import com.example.p_spring_53.model.Calculation;
import com.example.p_spring_53.service.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class CalculatorController {

    private final CalculatorService service;

    public CalculatorController(CalculatorService service) {
        this.service = service;
    }

    @GetMapping
    public String calculatorPage(Model model) {
        model.addAttribute("history", service.getAllCalculations());
        return "calculator";
    }

    @PostMapping
    public String calculate(@RequestParam String operation,
                            @RequestParam double operand1,
                            @RequestParam double operand2,
                            Model model) {
        try {
            Calculation calculation = service.calculate(operation, operand1, operand2);
            model.addAttribute("calculation", calculation);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        model.addAttribute("history", service.getAllCalculations());
        return "calculator";
    }
}
