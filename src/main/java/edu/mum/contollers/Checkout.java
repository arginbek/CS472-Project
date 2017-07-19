package edu.mum.contollers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.mum.dao.InventoryDAO;
import edu.mum.dao.OrderHistoryDAO;
import edu.mum.models.Cart;
import edu.mum.models.InventoryItem;
import edu.mum.models.Order;
import edu.mum.models.PaymentType;
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
		List<InventoryItem> missingItems = new ArrayList<>();

		for (InventoryItem item : items) {
			if (item.getQuantity() > inventoryItems.get(item.getProduct().getId()).getQuantity()) {
				// Add missing item to the list to alert user
				missingItems.add(item);
			}
		}

		if (missingItems.size() > 0) {
			// TODO Inform User

		} else {

			// TODO Save Order to History

			String billingAddress = request.getParameter("billing_address");
			String shippingAddress = request.getParameter("address");
			int selectedOption = Integer.parseInt(request.getParameter("CreditCardType"));
			PaymentType type = null;
			if (selectedOption == 1) {
				type = PaymentType.PayPal;
			} else if (selectedOption == 2) {
				type = PaymentType.Visa;
			} else {
				type = PaymentType.Debit;
			}

			Order order = new Order(cart, user, billingAddress, shippingAddress, type);
			OrderHistoryDAO.addOrder(order);

			// TODO Empty Cart
			
			Cart newCart = new Cart();
			
			request.getSession().setAttribute("cart", newCart);

			// TODO Redirect to Thank you Page
			response.sendRedirect("thankyou");
		}
	}

}
