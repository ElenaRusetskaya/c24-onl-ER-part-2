package by.teachmeskills.lesson29.ocp;

public class MasterCard implements Classification {
    private double accountBank;
    public MasterCard(double accountBank) {
        this.accountBank = accountBank;
    }

    @Override
    public String getClassification() {
        return "MasterCard";
    }
}
