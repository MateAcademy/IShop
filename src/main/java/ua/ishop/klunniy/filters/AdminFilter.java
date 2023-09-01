package ua.ishop.klunniy.filters;

import ua.ishop.klunniy.model.Role;
import ua.ishop.klunniy.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Serhii Klunniy
 */
@WebFilter(urlPatterns = {"/admin/*"})
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        User userFromSession = (User) httpServletRequest.getSession().getAttribute("user");
        if (userFromSession != null) {
            List<Role> listRole = userFromSession.getRoleList();
            Role admin = listRole.stream().filter(role -> role.getName().equals("admin")).findFirst().orElse(null);
            if (admin != null) {
                chain.doFilter(request, response);
            } else {
                httpServletResponse.sendRedirect("/login");
            }
        } else {
            httpServletResponse.sendRedirect("/login");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
