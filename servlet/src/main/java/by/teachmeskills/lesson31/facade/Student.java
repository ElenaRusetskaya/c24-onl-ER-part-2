package by.teachmeskills.lesson31.facade;

import java.util.logging.Logger;

public class Student {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(Student.class));
    public void doHWBeforeDeadline(BagTracker bagTracker) {
        if (bagTracker.isActiveProgram()) {
            LOGGER.info("The student performs hw");
        } else {
            LOGGER.info("The student has not started his homework");
        }
    }
}
