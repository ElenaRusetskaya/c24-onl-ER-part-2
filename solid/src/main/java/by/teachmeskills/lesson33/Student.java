package by.teachmeskills.lesson33;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student {
    private String name;
    private int course;
    private String group;

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        Student student = (Student) object;
        return (name != student.name || (name != null && name.equals(student.getName()))) && course != student.course
                && (group != student.group || (group != null && group .equals(student.getGroup())));
    }
    @Override
    public int hashCode() {
        final int anOddNumber = 31;
        int result = 1;
        result = anOddNumber * result + ((name != null) ? name.hashCode() : 0);
        result = anOddNumber * result + course;
        result = anOddNumber * result + ((group != null) ? 0 : group.hashCode());
        return result;
    }
    @Override
    public String toString() {
        return "Student:" + "Name -  " + name + ", Course - " + course +", Group - " + group;
    }
    @Override
    public Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }
}
