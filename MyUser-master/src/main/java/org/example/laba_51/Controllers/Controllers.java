package org.example.laba_51.Controllers;
import org.example.laba_51.Models.Users;
import org.example.laba_51.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class Controllers {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Users> users = usersRepository.findAll();
        model.addAttribute("users", users);
        return "index";
    }
    @GetMapping("/new-user")
    public String newUser(Model model) {
        return "new-user";
    }

    @PostMapping("/update/{id}")
    public String update(Model model, @PathVariable long id,
                         @RequestParam String name,
                         @RequestParam String surname,
                         @RequestParam int age,
                         @RequestParam String groupe_number) {
        Users user = usersRepository.findById(id).get();
        user.setName(name);
        user.setSurname(surname);
        user.setAge(age);
        user.setGroupe_number(groupe_number);
        usersRepository.save(user);
        return "redirect:/";

    }

    @PostMapping("/delete/{id}")
    public String delete(Model model, @PathVariable long id) {
        Users user = usersRepository.findById(id).get();
        usersRepository.delete(user);
        return "redirect:/";
    }
    @PostMapping("/add")
    public String addUser(Model model, @RequestParam String name,
                          @RequestParam String surname,
                          @RequestParam int age,
                          @RequestParam String groupe_number) {
        Users user = new Users(name, surname, age, groupe_number);
        usersRepository.save(user);
        return "redirect:/";
    }


}
