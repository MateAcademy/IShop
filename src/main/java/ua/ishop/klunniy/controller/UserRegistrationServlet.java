package ua.ishop.klunniy.controller;

import ua.ishop.klunniy.db.Storage;
import ua.ishop.klunniy.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Serhii Klunniy
 */
public class UserRegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email =  req.getParameter("email");
        String password =  req.getParameter("password");
        String rPassword = req.getParameter("rpassword");

        if (password.equals(rPassword)) {
            User user = new User(email, password);
            Storage.addUser(user);
            resp.sendRedirect("/");

            System.out.println("Мы зарегистрировались!!!!!!");
        } else {
            req.setAttribute("error", "Your password not correct");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }



    }




}
