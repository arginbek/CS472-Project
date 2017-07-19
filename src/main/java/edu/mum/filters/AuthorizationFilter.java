package edu.mum.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.mum.models.ErrorMessage;
import edu.mum.models.ErrorMessageType;
import edu.mum.models.User;
import edu.mum.models.UserType;

/**
 * Servlet Filter implementation class AuthorizationFilter
 */
@WebFilter(servletNames = { "inventory", "productupload", "checkout", "account" })
public class AuthorizationFilter implements Filter {

    public AuthorizationFilter() {
        // TODO Auto-generated constructor stub
    }

    public void destroy() {
        // TODO Auto-generated method stub
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if (req.getSession().getAttribute("user") != null) {
            if ("/inventory".equals(req.getServletPath())) {
                if (((User) req.getSession().getAttribute("user")).getType().equals(UserType.MANAGER)) {
                    chain.doFilter(request, response);
                } else {
                    resp.sendRedirect("index");
                }
            } else {
                chain.doFilter(request, response);
            }
        } else {
            req.getSession().setAttribute("errorMessage", new ErrorMessage(ErrorMessageType.OTHER, "Please login!"));
            resp.sendRedirect("login");
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

}
