package by.teachmeskills.lesson31.decorator;

public class Administrator extends EmployeeDecorator {
    public Administrator(Employee employee) {
        super(employee);
    }
    public String checkReport() {
        return "Check and submit the report";
    }

    @Override
    public String performWork() {
        return super.performWork() + checkReport();
    }
}
