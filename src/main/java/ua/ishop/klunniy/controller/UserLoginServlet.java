package ua.ishop.klunniy.controller;

import ua.ishop.klunniy.factory.UserServiceFactory;
import ua.ishop.klunniy.model.User;
import ua.ishop.klunniy.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

/**
 * @author Serhii Klunniy
 */

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {

    private static final UserService userService = UserServiceFactory.getUserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String loggin = (String) session.getAttribute("loggin");
        if (loggin ==null) {}

        String email =  req.getParameter("email");
        String password =  req.getParameter("password");

        User userFromDB = userService.getUserByEmail(email);
        String passwordUserFromDB = userFromDB.getPassword();

        //мы храним в атрибуте count количество посещений
        Integer count = (Integer) session.getAttribute("count");
        if (Objects.equals(count, null)) {
            session.setAttribute("count", 1);
        } else {
            session.setAttribute("count", ++count);
        }

        if (password.equals(passwordUserFromDB)) {
           // req.getRequestDispatcher("/main_admin_page.jsp").forward(req,resp);
            getServletContext().getRequestDispatcher("/main_admin_page.jsp").forward(req,resp);
        } else {
            req.setAttribute("error", "You have mistake in your login or password!");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }

    }
}
