package by.teachmeskills.lesson29.ocp;
public class CreditCard {
    public void CreditCard (Operation operation) {
        if (operation == null) {
            throw new IllegalArgumentException("Can not operation");
        }
        operation.operation();
    }
}
