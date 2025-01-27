package com.example.auth_hello_world.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная Страница");
        return "index";
    }
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("title", "Страница входа");
        return "login";
    }
}
