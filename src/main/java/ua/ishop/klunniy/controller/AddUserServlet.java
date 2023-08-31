package ua.ishop.klunniy.controller;

import org.apache.log4j.Logger;
import ua.ishop.klunniy.factory.UserServiceFactory;
import ua.ishop.klunniy.model.User;
import ua.ishop.klunniy.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Serhii Klunniy
 */
@WebServlet("/users/add")
public class AddUserServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(AddUserServlet.class);
    private static final UserService userService = UserServiceFactory.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.getRequestDispatcher("/add_user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = (String)req.getAttribute("email");
        String password = (String)req.getAttribute("password");

        User user = new User(email, password);
        userService.addUser(user);
        req.getRequestDispatcher("users").forward(req, resp);
    }
}
