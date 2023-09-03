package ua.ishop.klunniy.controller;

import org.apache.log4j.Logger;
import ua.ishop.klunniy.factory.UserServiceFactory;
import ua.ishop.klunniy.model.Role;
import ua.ishop.klunniy.model.User;
import ua.ishop.klunniy.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Serhii Klunniy
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(LoginServlet.class);

    private static final UserService userService = UserServiceFactory.getUserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(30); //120 sec

//todo - при логине я должен достать все роли из БД и покласть их в сессию
        User user = new User();
        user.setRoleList(new ArrayList<>(){{
            add(new Role("admin"));
        }});
        session.setAttribute("user", user);

        if (!isLogins20times(session)) {
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            User userFromDB = userService.findUserByEmail(email);
            String passwordUserFromDB = userFromDB.getPassword();

            if (password.equals(passwordUserFromDB)) {
//todo: что это означает?
                // req.getRequestDispatcher("/main_admin_page.jsp").forward(req,resp);
                logger.info("password equals true, userID=" + userFromDB.getUserId());
                getServletContext().getRequestDispatcher("/main_admin_page.jsp").forward(req, resp);
            } else {
                logger.warn("password not equals true, user email=" + email);
                req.setAttribute("error", "You have mistake in your login or password!");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        } else {
            logger.error("try to login > 20 times sessionId = " + session.getId());
            resp.sendRedirect("https://www.google.com");
        }
    }

    private synchronized boolean isLogins20times(HttpSession session) {
        Integer numberOfLogins = (Integer) session.getAttribute("numberOfLogins");
        if (Objects.equals(numberOfLogins, null)) {
            session.setAttribute("numberOfLogins", 1);
        } else {
            session.setAttribute("numberOfLogins", ++numberOfLogins);
            if (numberOfLogins >= 20) {
                return true;
            }
        }
        return false;
    }

}
