package by.teachmeskills.lesson26.service;

public class Parameter {
    public static boolean parameters (String name, String age, String gender, String education) {
        return name != null && !name.isEmpty() && age != null && !age.isEmpty()
                && gender != null && !gender.isEmpty() && education != null && !education.isEmpty();
    }
}
