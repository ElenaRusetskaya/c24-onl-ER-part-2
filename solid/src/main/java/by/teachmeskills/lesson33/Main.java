package by.teachmeskills.lesson33;
import by.teachmeskills.lesson33.Student;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        User user = new User(new Student("", 1, ""), "5");
        User copy = user.clone();
        System.out.println(user.getStudent() == copy.getStudent());
    }
}
