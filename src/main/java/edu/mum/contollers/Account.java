package edu.mum.contollers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import edu.mum.dao.UserDAO;
import edu.mum.models.User;

/**
 * Servlet implementation class Account
 */
@WebServlet(name = "account", urlPatterns = { "/account" })
public class Account extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String ACCOUNT = "WEB-INF/jsp/account.jsp";

    public Account() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(ACCOUNT).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String first = request.getParameter("first");
        String last = request.getParameter("last");
        ObjectMapper mapper = new ObjectMapper();
        user.setFirstName(first);
        user.setLastName(last);
        UserDAO.updateUser(user);
        PrintWriter out = response.getWriter();
        try {
            out.print(mapper.writeValueAsString(user));
            request.getSession().setAttribute("user", user);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        }
    }

}
