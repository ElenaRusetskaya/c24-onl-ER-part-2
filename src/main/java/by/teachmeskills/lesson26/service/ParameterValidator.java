package by.teachmeskills.lesson26.service;

public class ParameterValidator {
    public static boolean parameters (String name, String age, String gender, String education) {
        return name != null && !name.isBlank() && age != null && !age.isEmpty()
                && gender != null && !gender.isEmpty() && education != null && !education.isEmpty();
    }
}
