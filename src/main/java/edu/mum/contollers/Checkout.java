package edu.mum.contollers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.mum.dao.InventoryDAO;
import edu.mum.models.Cart;
import edu.mum.models.InventoryItem;
import edu.mum.models.User;

/**
 * Servlet implementation class AddTOCart
 */
@WebServlet(name = "checkout", urlPatterns = { "/checkout" })
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Checkout() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/jsp/checkout.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get Cart
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		// Get User
		User user = (User) request.getSession().getAttribute("user");

		// TODO Check if products exist
		List<InventoryItem> items = cart.getAllCartItems();
		Map<String, InventoryItem> inventoryItems = InventoryDAO.getInventory();

		// TODO Save Order to History
		// TODO Empty Cart
		// TODO Redirect to Thank you Page

	}

}
