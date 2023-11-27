package by.teachmeskills.lesson31.facade;

public class BagTracker {
    private boolean activeProgram;

    public boolean isActiveProgram() {
        return activeProgram;
    }
    public void startProgram() {
        System.out.println("Program is active");
        activeProgram = true;
    }
    public void finishProgram() {
        System.out.println("Program is not active");
        activeProgram = false;
    }
}
