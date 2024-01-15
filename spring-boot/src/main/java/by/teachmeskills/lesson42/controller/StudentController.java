package by.teachmeskills.lesson42.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {
    @GetMapping("")
    public String toStudent(Model model) {
        model.addAttribute("name", "Bob");
        model.addAttribute("group", "101");
        model.addAttribute("course", "1");
        return "student/student";
    }
    @GetMapping("/new_student")
    public String toAddStudent() {
        return "student/new_student";
    }
    @PostMapping("/new_student/create")
    public String createStudent(@RequestParam String name, @RequestParam String group, @RequestParam String course) {
        System.out.printf("Name: %s; Group: %s; Course: %s \n", name, group, course);
        return "redirect:/student";
    }
}