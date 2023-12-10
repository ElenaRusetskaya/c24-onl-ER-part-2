package by.teachmeskills.lesson32;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/frontController")
public class FrontController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String frontController = request.getParameter("frontController");
        Controller interfaceFC = null;
        if ("Age".equals(frontController)) {
            interfaceFC = new AgeDispatcher();
        } else {
            interfaceFC = new TimeDispatcher();
        }
        String controller = interfaceFC.execute(request, response);
        request.getRequestDispatcher(controller+ ".jsp").forward(request, response);
    }
}
