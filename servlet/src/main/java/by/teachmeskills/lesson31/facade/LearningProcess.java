package by.teachmeskills.lesson31.facade;

public class LearningProcess {
    Student student = new Student();
    Training training = new Training();
    BagTracker bagTracker = new BagTracker();

    public void solvingHomeWork() {
        training.doTraining();
        bagTracker.startProgram();
        student.doHWBeforeDeadline(bagTracker);
    }
}
