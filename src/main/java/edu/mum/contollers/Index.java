package edu.mum.contollers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.mum.models.Cart;
import edu.mum.models.InventoryItem;
import edu.mum.dao.*;
import edu.mum.models.Product;

/**
 * Servlet implementation class Index
 */
@WebServlet("/index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Index() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setAttribute("values", InventoryDAO.getAllItems());
		// int[] arr = {1,2,3};
		// request.setAttribute("values", arr);

		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		// TODO Set the cart view value

		request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		// Product product = new Product();
		// product.setName(request.getParameter("name"));
		// product.setPrice(Double.valueOf(request.getParameter("price")));
		// product.setId(request.getParameter("id"));
		//
		// Cart cart = (Cart) request.getSession().getAttribute("cart");
		//
		// InventoryItem inItem = new InventoryItem(product, 1);
		//
		// boolean isAdded = cart.addItem(inItem);
		//
		// request.getSession().setAttribute("cart", cart);
		//
		// System.out.println("Is added: "+isAdded+"
		// "+cart.getAllCartItems().size());

	}

}
