package by.itclass;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

@WebServlet("/handler")
public class SessionController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var session = req.getSession();
//        resp.getWriter()
//                .append("Creation time: " + new Date(session.getCreationTime()));
        req.setAttribute("requestMessage", "I am request attr");
        session.setAttribute("sessionMessage", "I am session attr");
        req.getRequestDispatcher("/message").forward(req, resp);
    }
}
