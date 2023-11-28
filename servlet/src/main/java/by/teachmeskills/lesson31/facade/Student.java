package by.teachmeskills.lesson31.facade;

public class Student {
    public void doHWBeforeDeadline(BagTracker bagTracker) {
        if (bagTracker.isActiveProgram()) {
            System.out.println("The student performs hw");
        } else {
            System.out.println("The student has not started his homework");
        }
    }
}
