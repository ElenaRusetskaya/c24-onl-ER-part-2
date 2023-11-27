package by.teachmeskills.lesson31.decorator;

public class Task {
    public static void main(String[] args) {
        Employee employee = new Administrator(new SecondEmployee(new FirstEmployee()));
        System.out.println(employee.performWork());
    }
}
