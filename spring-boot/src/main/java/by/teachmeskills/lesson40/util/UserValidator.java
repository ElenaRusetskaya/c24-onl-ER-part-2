package by.teachmeskills.lesson40.util;

import by.teachmeskills.lesson40.model.User;
import by.teachmeskills.lesson40.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (userService.getOne(user.getEmail()) != null) {
            errors.rejectValue("email", "", "This email is busy");
        }
    }
}
