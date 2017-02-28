package pl.sda;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * Created by m.losK on 2017-02-28.
 */
public class PathServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");
        writer.write("Hello world!");

        String requestURI = req.getRequestURI();
//        String name = requestURI.substring(requestURI.lastIndexOf("/") + 1);
//        writer.write("<h1>" + name + "</h1>");

        List<String> names = Arrays.asList("Mateusz", "Anna", "Piotr", "Pawel");
        int index = Integer.valueOf(requestURI.substring(requestURI.lastIndexOf("/") + 1));
        writer.write("<h2>" + names.get(index) + "</h2>");

    }
}
