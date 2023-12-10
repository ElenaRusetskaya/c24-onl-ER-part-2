package by.teachmeskills.lesson33;
import by.teachmeskills.lesson33.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User implements Cloneable {

    private Student student;

    private String grade;

    @Override
    public User clone() throws CloneNotSupportedException {
        User copy = (User) super.clone();
        copy.student = student.clone();
        return copy;
    }
}
