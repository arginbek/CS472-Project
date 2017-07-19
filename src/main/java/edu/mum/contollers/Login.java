package edu.mum.contollers;

import java.io.IOException;
import java.util.logging.ErrorManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.mum.dao.CartDAO;
import edu.mum.dao.UserDAO;
import edu.mum.models.Cart;
import edu.mum.models.ErrorMessage;
import edu.mum.models.ErrorMessageType;
import edu.mum.models.User;

/**
 * Servlet implementation class Login
 */
@WebServlet({ "/login" })
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String LOGIN = "WEB-INF/jsp/login.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            if ("signout".equals(request.getParameter("action"))) {
                HttpSession session = request.getSession(false);
                if (session != null) {
                    if (session.getAttribute("cart") != null) {
                        CartDAO.addCart((User) session.getAttribute("user"), (Cart) session.getAttribute("cart"));
                    }
                    session.invalidate();
                }
                response.sendRedirect("login");
            } else {
                response.sendRedirect("index");
            }
        } else {
            request.getRequestDispatcher(LOGIN).forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("username");
        String action = request.getParameter("action");

        switch (action) {
        case "signin":
            String password = request.getParameter("password");
            String remember = request.getParameter("rememberme");
            if (UserDAO.getUserList().containsKey(userName)
                    && password.equals(UserDAO.getUserList().get(userName).getPassword())) {
                request.getSession().setAttribute("user", UserDAO.getUserList().get(userName));
                request.getSession().removeAttribute("errorMessage");
                
                //set cart saved in last session
                if(CartDAO.checkCartByUsername(userName)){
                    request.getSession().setAttribute("cart", CartDAO.getCartByUserName(userName));
                    //deleting it from DB after saving it to the session
                    CartDAO.deleteCartByUserName(userName);
                }
                
                if (remember != null) {
                    Cookie c = new Cookie("userName", userName);
                    c.setPath("/webstore");
                    c.setMaxAge(24 * 60 * 60 * 30);
                    response.addCookie(c);
                } else {
                    Cookie c = new Cookie("userName", null);
                    c.setPath("/webstore");
                    c.setMaxAge(0);
                    response.addCookie(c);
                }
                response.sendRedirect("index");
            } else {
                // ObjectMapper mapper = new ObjectMapper();
                // response.getWriter().print(mapper.writeValueAsString(
                // new ErrorMessage(ErrorMessageType.LOGIN, "Please login using
                // an
                // valid username and password")));
                // response.setStatus(401);
                request.getSession().setAttribute("errorMessage",
                        new ErrorMessage(ErrorMessageType.SIGNIN, "Please login using an valid username and password"));
                response.sendRedirect("login");
            }
            break;
        case "signup":
            boolean success = false;
            if (UserDAO.getUserList().containsKey(request.getParameter("username"))) {
                request.getSession().setAttribute("signupError",
                        new ErrorMessage(ErrorMessageType.SIGNUP, "Please choose another username"));
            } else if (!UserDAO.validateEmail(request.getParameter("email"))) {
                request.getSession().setAttribute("signupError",
                        new ErrorMessage(ErrorMessageType.SIGNUP, "Email address is already in use"));
            } else if (!request.getParameter("pass1").equals(request.getParameter("pass2"))) {
                request.getSession().setAttribute("signupError",
                        new ErrorMessage(ErrorMessageType.SIGNUP, "Password confimration failed"));
            } else {
                User user = new User(request.getParameter("username"), request.getParameter("first"),
                        request.getParameter("last"), request.getParameter("email"), request.getParameter("pass1"));
                UserDAO.addUser(user);
                request.getSession().removeAttribute("signupError");
                request.getSession().setAttribute("errorMessage",
                        new ErrorMessage(ErrorMessageType.SIGNIN, "Please login using your new account"));
                success = true;
            }
            if (success)
                response.sendRedirect("login");
            else
                response.sendRedirect("login#tab-2");
            break;
        default:
            break;
        }

    }

}
