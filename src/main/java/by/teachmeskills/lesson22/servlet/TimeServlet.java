package by.teachmeskills.lesson22.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Задача 1:
 * Создать приложение, которое при переходе на следующие урлы будет выдавать
 * результат:
 * /minsk - время в Минске
 * /washington - время в Вашингтоне
 * /beijing - время в Пекине
 * При решении использовать оба варианта настройки (xml и аннотации).
 */
@WebServlet(urlPatterns = { "/minsk", "/chicago", "/shanghai"})
public class TimeServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getServletPath();
        String continentTime;
        if ("/minsk".equals(path)) {
            continentTime = "Europe/Minsk";
        } else if ("/chicago".equals(path)) {
            continentTime = "America/Chicago";
        } else if ("/shanghai".equals(path)) {
            continentTime = "Asia/Shanghai";
        } else {
            continentTime = "Something went wrong";
        }
        ZonedDateTime nowTime = ZonedDateTime.now(ZoneId.of(continentTime));
        response.getWriter().write(continentTime + " - " + nowTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a")));
    }
}
