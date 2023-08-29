//package ua.ishop.klunniy.filters;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Objects;
//
///**
// * @author Sergey Klunniy
// */
//@WebFilter(urlPatterns = {"/index.jsp"})
//public class IndexPageFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//
////todo можно сделать обращение в БД и поиск роли
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//        Integer numberOfInputs = (Integer) httpRequest.getSession().getAttribute("numberOfInputsMainPage");
//        if (Objects.equals(numberOfInputs, null)) {
//            httpRequest.getSession().setAttribute("current_user", null);
//            chain.doFilter(request, response);
//        } else {
//            httpResponse.sendRedirect("403.jsp");
//        }
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//}
