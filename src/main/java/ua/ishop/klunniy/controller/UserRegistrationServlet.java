package ua.ishop.klunniy.controller;

import org.apache.log4j.Logger;
import ua.ishop.klunniy.factory.UserServiceFactory;
import ua.ishop.klunniy.model.User;
import ua.ishop.klunniy.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Serhii Klunniy
 */
public class UserRegistrationServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(UserRegistrationServlet.class);

    private static final UserService userService = UserServiceFactory.getUserService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("register.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email =  req.getParameter("email");
        String password =  req.getParameter("password");
        String rPassword = req.getParameter("rpassword");


        if (password.equals(rPassword)) {
            User user = new User(email, password);
//            Storage.addUser(user);
            userService.addUser(user);
            resp.sendRedirect("/");

            System.out.println("Мы зарегистрировались!!!!!!");
        } else {
            req.setAttribute("error", "Your password not correct");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
    }

}
