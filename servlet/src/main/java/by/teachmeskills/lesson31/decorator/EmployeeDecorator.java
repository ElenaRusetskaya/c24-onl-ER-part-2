package by.teachmeskills.lesson31.decorator;

public class EmployeeDecorator implements Employee {
    Employee employee;
    public EmployeeDecorator(Employee employee) {
        this.employee = employee;
    }
    @Override
    public String performWork() {
        return employee.performWork();
    }
}
