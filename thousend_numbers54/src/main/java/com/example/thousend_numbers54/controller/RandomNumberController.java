package com.example.thousend_numbers54.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class RandomNumberController {

    @GetMapping("/")
    public String showForm() {
        return "random_numbers";
    }

    @PostMapping("/generate")
    public String generateNumbers(@RequestParam int min, @RequestParam int max, Model model) {
        if (min >= max) {
            model.addAttribute("error", "Минимальное значение должно быть меньше максимального.");
            return "random_numbers";
        }

        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            numbers.add(random.nextInt(max - min + 1) + min);
        }

        double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0);

        model.addAttribute("numbers", numbers);
        model.addAttribute("average", average);

        return "random_numbers";
    }
}

