package by.teachmeskills.lessin41.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    @GetMapping("/user/{name}")
    public String view(@PathVariable("name") String name, Model model) {
        model.addAttribute("", "Hello " + name);
        return "/user";
    }
    @PostMapping("/helloSpringBoot")
    public String helloSpringBoot(@RequestParam String newModule, Model model) {
        model.addAttribute("newModule", newModule);
        return "helloSpringBoot";
    }
}
