package by.teachmeskills.lesson31.decorator;

import java.util.logging.Logger;

public class Task {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(Task.class));
    public static void main(String[] args) {
        Employee employee = new Administrator(new SecondEmployee(new FirstEmployee()));
        //System.out.println(employee.performWork());
        LOGGER.info(employee.performWork());
    }
}
