package ua.ishop.klunniy.controller;

import org.apache.log4j.Logger;
import ua.ishop.klunniy.factory.UserServiceFactory;
import ua.ishop.klunniy.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/delete")
public class DeleteUserServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(DeleteUserServlet.class);
    private static final UserService userService = UserServiceFactory.getUserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("userId"));
        userService.deleteUserById(id);
        resp.sendRedirect("/users");
    }
}
