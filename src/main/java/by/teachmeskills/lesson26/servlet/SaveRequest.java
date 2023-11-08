package by.teachmeskills.lesson26.servlet;

import by.teachmeskills.lesson26.service.Parameter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/save-request")
public class SaveRequest extends HttpServlet {
    /**
     * Создать страницу save-request.jsp, содержащую форму для ввода заявки. Форма должна
     * отправлять данные в POST запросе сервлету, который их проверяет. Если одно из полей
     * не указано, сервлет должен снова перенаправить на страницу ввода данных. Если
     * указаны верно, сервлет должен перенаправить на страницу, на которой нужно отобразить
     * текст: «Заявка успешно сохранена" с отображенной информацией из формы.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String education = request.getParameter("education");
        if (Parameter.parameters (name, age, gender, education)) {
            request.setAttribute("message", "One of the fields is not specified correctly");
            request.getServletContext().getRequestDispatcher("/WEB-INF/save-request.jsp").forward(request, response);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/application.jsp").forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/WEB-INF/save-request.jsp").forward(request, response);
    }
}

