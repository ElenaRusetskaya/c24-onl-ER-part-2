package by.teachmeskills.lesson31.facade;

import java.util.logging.Logger;

public class Student {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(Student.class));
    public void doHWBeforeDeadline(BagTracker bagTracker) {
        if (bagTracker.isActiveProgram()) {
            //System.out.println("The student performs hw");
            LOGGER.info("The student performs hw");
        } else {
            //System.out.println("The student has not started his homework");
            LOGGER.info("The student has not started his homework");
        }
    }
}
