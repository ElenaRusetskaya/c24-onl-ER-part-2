package by.teachmeskills.lesson35;

import java.sql.Connection;
import java.sql.Statement;

public class TableData {
    public static void database() {
        try (Connection connection = (Connection) Main.getConnection();
             Statement statement = connection.createStatement()) {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS users ("
                    + "name VARCHAR,"
                    + "course VARCHAR,"
                    + "group VARCHAR,"
                    + "id INT AUTO_INCREMENT PRIMARY KEY,";
            statement.executeUpdate(createTableQuery);
            String insertDataQuery = "INSERT INTO users (name, course, group, id) VALUES ('Ban', 4, 114, 456789), ('Petr', 4, 113, 789456), (Bob, 5, 115, 123456)";
            statement.executeUpdate(insertDataQuery);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
