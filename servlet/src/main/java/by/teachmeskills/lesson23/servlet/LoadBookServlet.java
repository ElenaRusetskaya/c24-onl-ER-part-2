package by.teachmeskills.lesson23.servlet;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(urlPatterns = "/load-book")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 *10)
public class LoadBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Part filePart = request.getPart("file");
            String name = filePart.getSubmittedFileName();
            filePart.write("F:\\" + name);
            response.getWriter().print("The file uploaded successfully ");
        } catch (Exception exception) {
            response.getWriter().print("Something wrong ");
        }
    }
}
