package by.teachmeskills.lesson29.ocp;

public class AddAmount implements Operation {
    private double accountBank;
    private double theAmount;
    private double totalAmount= 0;
    public AddAmount (double accountBank, double theAmount) {
        this.accountBank = accountBank;
        this.theAmount = theAmount;
    }
    @Override
    public void operation() {
        totalAmount = accountBank + theAmount;
    }
}
