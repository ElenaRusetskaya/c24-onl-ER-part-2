package by.teachmeskills.lesson33;

public class Student {
    private String name;
    private int course;
    private String group;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCourse() {
        return course;
    }
    public void setCourse(int course) {
        this.course = course;
    }
    public String getGroup() {
        return group;
    }
    public void setGroup(String group) {
        this.group = group;
    }
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
}
