package by.teachmeskills.lesson30.Builder;

import java.util.logging.Logger;

public class House {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(House.class));
    public static void main(String[] args)
    {
        Flat number1 = new Flat();
        Flat number2 = new Flat();

        number1.setNumber(1).setNumberOfRooms(2).setFloor("101");
        number2.setNumber(2).setNumberOfRooms(3).setFloor("102");

        LOGGER.info(String.valueOf(number1));
        LOGGER.info(String.valueOf(number2));
    }
}
