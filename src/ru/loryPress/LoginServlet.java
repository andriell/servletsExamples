package ru.loryPress;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andriell on 12.11.15.
 */
public class LoginServlet extends HttpServlet {
    public void sendLoginForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/login-form.html");
        rd.include(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        sendLoginForm(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (login != null && password != null && login.equals("admin") && password.equals("password")) {
            req.getRequestDispatcher("/req-info?t[]=100500&t[]=5").forward(req, resp);
        } else {
            resp.sendRedirect("/login-form.html");
        }
    }
}
