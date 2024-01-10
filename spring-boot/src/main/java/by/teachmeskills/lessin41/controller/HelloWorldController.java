package by.teachmeskills.lessin41.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    @GetMapping("/newModule")
    public String helloNewModule() {
        return "user";
    }
    @PostMapping("/helloSpringBoot")
    public String helloSpringBoot(@RequestParam String newModule, Model model) {
        model.addAttribute("newModule", newModule);
        return "helloSpringBoot";
    }
}
