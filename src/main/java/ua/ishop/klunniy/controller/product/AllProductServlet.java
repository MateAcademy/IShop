package ua.ishop.klunniy.controller.product;

import org.apache.log4j.Logger;
import ua.ishop.klunniy.controller.admin.AllUserServlet;
import ua.ishop.klunniy.factory.ProductDaoFactory;
import ua.ishop.klunniy.factory.ProductServiceFactory;
import ua.ishop.klunniy.factory.UserServiceFactory;
import ua.ishop.klunniy.model.Product;
import ua.ishop.klunniy.service.ProductService;
import ua.ishop.klunniy.service.UserService;
import ua.ishop.klunniy.service.imp.ProductServiceImpl;

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
@WebServlet("/product")
public class AllProductServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(AllProductServlet.class);
    private static final ProductService productService = ProductServiceFactory.getProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            List<Product> products = productService.getProducts();

            logger.info("we get all products" + req.getSession().getAttribute("user"));

            //достаю продукты из БД
            req.setAttribute("allProducts", products);
            req.getRequestDispatcher("/products.jsp").forward(req, resp);
        } catch (Exception e) {
           logger.error("we didnt get all products" + req.getSession().getAttribute("user") + e);
        }

    }


}

