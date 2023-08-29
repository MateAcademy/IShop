package ua.ishop.klunniy.controller;

import org.apache.log4j.Logger;
import ua.ishop.klunniy.model.User;
import ua.ishop.klunniy.service.UserService;
import ua.ishop.klunniy.service.imp.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Serhii Klunniy
 */
@WebServlet("/users")
public class AllUserServlet extends HttpServlet {

    private static final UserService userService = new UserServiceImpl();
    private static final Logger logger = Logger.getLogger(AllUserServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> allUsers = userService.getUsers();
        req.setAttribute("allUsers", allUsers);
        req.getRequestDispatcher("users.jsp").forward(req, resp);
    }
}
