package by.teachmeskills.lesson31.decorator;

public class SecondEmployee extends EmployeeDecorator {
    public SecondEmployee(Employee employee) {
        super(employee);
    }
    public String Report() {
        return "Make a report";
    }

    @Override
    public String performWork() {
        return super.performWork() + Report();
    }
}
