package ua.ishop.klunniy.controller.product;

import org.apache.log4j.Logger;
import ua.ishop.klunniy.controller.admin.AllUserServlet;
import ua.ishop.klunniy.factory.ProductServiceFactory;
import ua.ishop.klunniy.factory.UserServiceFactory;
import ua.ishop.klunniy.model.Product;
import ua.ishop.klunniy.model.User;
import ua.ishop.klunniy.service.ProductService;
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
@WebServlet("/products/update")
public class UpdateProductServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(UpdateProductServlet.class);
    private static final UserService userService = UserServiceFactory.getUserService();
    private static final ProductService productService = ProductServiceFactory.getProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("productId"));
        Product productById = productService.getProductById(id);
        req.setAttribute("product", productById);
        req.getRequestDispatcher("/update_product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            String  id = req.getParameter("id");
            String  name = req.getParameter("name");
            String  price = req.getParameter("price");
            String  description = req.getParameter("description");

            Product product = new Product(Long.parseLong(id), name, Double.parseDouble(price), description);
            productService.updateProduct(product);
            resp.sendRedirect("/product");
        } catch (Exception e) {
            logger.error(" ...... " + e);
        }


    }
}
