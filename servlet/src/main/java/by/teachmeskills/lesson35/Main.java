package by.teachmeskills.lesson35;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static final String URL = "jdbc:postgresql://localhost:5432";
    public static Main getConnection() throws SQLException {
        return (Main) DriverManager.getConnection(URL);
    }
}
