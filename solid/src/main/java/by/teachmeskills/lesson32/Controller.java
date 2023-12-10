package by.teachmeskills.lesson32;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
    String execute (HttpServletRequest request, HttpServletResponse response);
}
