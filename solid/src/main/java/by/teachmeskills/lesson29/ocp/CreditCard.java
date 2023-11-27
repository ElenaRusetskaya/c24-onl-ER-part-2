package by.teachmeskills.lesson29.ocp;
public class CreditCard {
    public String getClassofocation (Classification classification) {
        if (classification == null) {
            throw new IllegalArgumentException("Something went wrong");
        }
        return classification.getClassification();
    }
}
