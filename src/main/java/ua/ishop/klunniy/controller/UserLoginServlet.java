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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

/**
 * @author Serhii Klunniy
 */
@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(UserLoginServlet.class);

    private static final UserService userService = UserServiceFactory.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (numberOfInputs(resp, session)) {
            String email =  req.getParameter("email");
            String password =  req.getParameter("password");

            User userFromDB = userService.getUserByEmail(email);
            String passwordUserFromDB = userFromDB.getPassword();

            if (password.equals(passwordUserFromDB)) {
                visitCounter(session);
                // req.getRequestDispatcher("/main_admin_page.jsp").forward(req,resp);
                getServletContext().getRequestDispatcher("/main_admin_page.jsp").forward(req,resp);
            } else {
                req.setAttribute("error", "You have mistake in your login or password!");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        }
    }

    private synchronized boolean numberOfInputs(HttpServletResponse resp, HttpSession session) throws IOException {
        Integer numberOfInputs = (Integer) session.getAttribute("numberOfInputs");
        if (Objects.equals(numberOfInputs, null)) {
            session.setMaxInactiveInterval(10000);
            session.setAttribute("numberOfInputs", 1);
            session.setAttribute("numberOfInputsMainPage", 1);
        } else {
            session.setAttribute("numberOfInputs", ++numberOfInputs);
            if (numberOfInputs >=5) {
                System.out.println("redirect google.com");
                resp.sendRedirect("https://www.google.com");
                return false;
            }
        }
        return true;
    }

    private synchronized void visitCounter(HttpSession session) {
        //мы храним в атрибуте count количество посещений страницы user_admin_page.jsp
        Integer count = (Integer) session.getAttribute("count");
        if (Objects.equals(count, null)) {
            session.setAttribute("count", 1);
        } else {
            session.setAttribute("count", ++count);
        }
    }
}
