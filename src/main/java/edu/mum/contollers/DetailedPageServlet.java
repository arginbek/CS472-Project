package edu.mum.contollers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.mum.dao.InventoryDAO;
import edu.mum.models.Cart;
import edu.mum.models.InventoryItem;
import edu.mum.models.Product;

/**
 * Servlet implementation class DetailedPageServlet
 */
@WebServlet(name ="detailedPage", urlPatterns={"/detailedPage"})
public class DetailedPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailedPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = request.getParameter("id");
		InventoryItem item = InventoryDAO.getInventory().get(id);
		Product product = item.getProduct();
		
		
		String name = product.getName();
		String description = product.getDescription();
		double price = product.getPrice();
		String imageName = product.getImgName();
		
		
		
		request.setAttribute("id", id);
		request.setAttribute("name", name);
		request.setAttribute("imgName", imageName);
		
		request.setAttribute("description", description);
		request.setAttribute("price", price);
		
		request.getRequestDispatcher("WEB-INF/jsp/detailed.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String id = request.getParameter("id");
		InventoryItem item = InventoryDAO.getInventory().get(id);
		Product product = item.getProduct();

		Cart cart = (Cart) request.getSession().getAttribute("cart");

		InventoryItem inItem = new InventoryItem(product, 1);

		boolean isAdded = cart.addItem(inItem);

		request.getSession().setAttribute("cart", cart);
		
	}

}
