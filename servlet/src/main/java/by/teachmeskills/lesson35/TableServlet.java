package by.teachmeskills.lesson35;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/student")
public class TableServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TableData.database();
        String selectFrom = "select * from student";
        try (Connection connection = (Connection) Main.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectFrom)) {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String course = resultSet.getString("course");
                String group = resultSet.getString("group");
                int id = resultSet.getInt("id");
                System.out.println("Name: " + name + ", Course: " + course + ", Group: " + group + ", ID: " + id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
