package by.teachmeskills.lesson32;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeDispatcher implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "TimeServlet";
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getServletPath();
        String continentTime;
        if ("/minsk".equals(path)) {
            continentTime = "Europe/Minsk";
        } else {
            continentTime = "Something went wrong";
        }
        ZonedDateTime nowTime = ZonedDateTime.now(ZoneId.of(continentTime));
        response.getWriter().write(continentTime + " - " + nowTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a")));
    }
}
