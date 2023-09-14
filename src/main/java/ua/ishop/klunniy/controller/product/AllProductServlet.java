package ua.ishop.klunniy.controller.product;

import org.apache.log4j.Logger;
import ua.ishop.klunniy.controller.admin.AllUserServlet;
import ua.ishop.klunniy.factory.UserServiceFactory;
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
@WebServlet("/product")
public class AllProductServlet extends HttpServlet {

        private static final Logger logger = Logger.getLogger(AllProductServlet.class);
//        private static final UserService userService = UserServiceFactory.getUserService();

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("allUsers", userService.getUsers());
            req.getRequestDispatcher("/users.jsp").forward(req, resp);
        }


    }

