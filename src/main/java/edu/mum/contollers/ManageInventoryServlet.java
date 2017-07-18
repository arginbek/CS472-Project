package edu.mum.contollers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.mum.dao.InventoryDAO;
import edu.mum.models.InventoryItem;
import edu.mum.models.Product;

/**
 * Servlet implementation class ManageInventoryServlet
 */
@WebServlet("/manageinventory")
public class ManageInventoryServlet extends HttpServlet {
	ObjectMapper mapper = new ObjectMapper();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action") == null ? "" : request.getParameter("action");
		switch (action) {
		default:
			HttpSession session = request.getSession();
			//dao = new InventoryDAO();
			List<InventoryItem> allItem = InventoryDAO.getAllItems();
			session.setAttribute("inventory", allItem);
			RequestDispatcher disp = request.getRequestDispatcher("manage-inventory.jsp");
			disp.forward(request, response);
			// response.sendRedirect("manage-inventory.jsp");
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<InventoryItem> allItem = InventoryDAO.getAllItems();
		Product product = null;
		for (InventoryItem item : allItem) {
			if (item.getProduct().getId().equals(request.getParameter("id"))) {
				item.getProduct().setPrice(Double.parseDouble(request.getParameter("price")));
				item.setQuantity(Integer.parseInt(request.getParameter("price")));
				product = item.getProduct();
				break;
			}
		}
		PrintWriter out = response.getWriter();
		if (product != null) {
			try {
				out.print(mapper.writeValueAsString(product));
			} catch (JsonGenerationException e) {
				e.printStackTrace();
			}
		} else {
			out.print("");
		}
	}

}
