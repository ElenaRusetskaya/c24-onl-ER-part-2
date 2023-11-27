package by.teachmeskills.lesson29.ocp;

public class Visa implements Classification {
    private double accountBank;
    public Visa(double accountBank) {
        this.accountBank = accountBank;
    }

    @Override
    public String getClassification() {
        return "Visa";
    }
}
