package by.teachmeskills.lesson32;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AgeServlet implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "AgeServlet";
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int age = 0;
        try {
            age = Integer.parseInt(request.getParameter("age")); }
        catch (NumberFormatException exception) {
            response.getWriter().println("Age is not set");
            return;
        }
        String abultOrMonor = age >= 18 ? "Adult" : "Minor";
        response.getWriter().println(abultOrMonor);
    }
}
