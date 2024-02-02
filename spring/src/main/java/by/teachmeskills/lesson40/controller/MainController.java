package by.teachmeskills.lesson40.controller;

import by.teachmeskills.lesson40.dto.UserDto;
import by.teachmeskills.lesson40.service.UserService;
import by.teachmeskills.lesson40.util.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@Validated
@Controller
public class MainController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserValidator userValidator;
    @GetMapping("/view/{name}")
    public String view(@PathVariable("name") String name, Model model) {
        model.addAttribute("", "Hello " + name);
        return "/index";
    }
    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "/users";
    }
    @GetMapping(path = "/{name}/studentFile", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getStudentByName(@PathVariable String name) {
        return ResponseEntity.ok(userService.getOne(name).getStudentPicture());
    }
    @PostMapping("/users/new")
    public String registration(@RequestParam MultipartFile multipartFile,
                               @ModelAttribute @Valid UserDto userDto, BindingResult result) throws IOException {
        userDto.setStudentPicture(multipartFile.getBytes());
        userValidator.validate(userDto, result);
        if (result.hasErrors()) {
            return "/registration";
        }
        userService.add(userDto);
        return "redirect:/users";
    }
}
