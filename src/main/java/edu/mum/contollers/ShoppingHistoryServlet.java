package edu.mum.contollers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.mum.dao.InventoryDAO;
import edu.mum.dao.OrderHistoryDAO;
import edu.mum.models.InventoryItem;
import edu.mum.models.Order;
import edu.mum.models.User;

/**
 * Servlet implementation class ShoppingHistoryServlet
 */
@WebServlet("/shoppinghistory")
public class ShoppingHistoryServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			User currentUser = (User)session.getAttribute("user");
			List<Order> allOrder = OrderHistoryDAO.getOrderByUsername(currentUser.getUserName());
			session.setAttribute("orders", allOrder);
			RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/jsp/order-history.jsp");
			disp.forward(request, response);
	}

}
