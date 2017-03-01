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
 * Created by m.losK on 2017-03-01.
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = Arrays.asList(new User("Mateusz", "Loska"),
                new User("Anna", "Loska"));
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
//        writeUsers(userList, writer);
//        writeUsersWithParam(req, userList, writer);
        String requestURI = req.getRequestURI();
        String counterAsString = requestURI.substring(requestURI.lastIndexOf('/') + 1);
        Integer index = new Integer(counterAsString);
        User user = userList.get(index);
        writer.write("<h1>" + user.getFirstName() + " " + user.getLastName() + "</h1>");
    }

    private void writeUsersWithParam(HttpServletRequest req, List<User> userList, PrintWriter writer) {
        Integer counter = new Integer(req.getParameter("counter"));
        writer.write("<ul>");
        userList.stream()
                .limit(counter)
                .forEach(e -> writer.write("<li>" + e.getFirstName() + " " + e.getLastName() + "</li>"));
        writer.write("</ul>");
    }

    private void writeUsers(List<User> userList, PrintWriter writer) {
        writer.write("<ul>");
        userList.forEach(e -> writer.write("<li>" + e.getFirstName() + " " + e.getLastName() + "</li>"));
        writer.write("</ul>");
    }
}
