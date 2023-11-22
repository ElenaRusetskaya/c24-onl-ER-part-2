package by.teachmeskills.lesson30.Builder;
public class House {
    public static void main(String[] args)
    {
        Flat number1 = new Flat();
        Flat number2 = new Flat();

        number1.setNumber(1).setNumberOfRooms(2).setFloor("101");
        number2.setNumber(2).setNumberOfRooms(3).setFloor("102");

        System.out.println(number1);
        System.out.println(number2);
    }
}
