package by.teachmeskills.lesson22.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Задача 2:
 * Создать сервлет который на вход принимает возраст, а в ответе возвращает
 * информацию, совершеннолетний или нет.
 */
@WebServlet(urlPatterns = {"/age"})
public class AgeServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int age = 0;
        try {
            age = Integer.parseInt(request.getParameter("age")); }
        catch (NumberFormatException exception) {
            response.getWriter().println(age >= 18 ? "Adult" : "Minor");
        }
    }
}
