package by.teachmeskills.lesson33;

import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(Main.class));
    public static void main(String[] args) throws CloneNotSupportedException {
        User user = new User(new Student("", 1, ""), "5");
        User copy = user.clone();
        //System.out.println(user.getStudent() == copy.getStudent());
        LOGGER.info(String.valueOf(user.getStudent() == copy.getStudent()));
    }
}
