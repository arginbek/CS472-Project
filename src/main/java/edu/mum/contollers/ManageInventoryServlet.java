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
@WebServlet(name = "inventory", urlPatterns = { "/inventory" })
public class ManageInventoryServlet extends HttpServlet {
	ObjectMapper mapper = new ObjectMapper();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action") == null ? "" : request.getParameter("action");
		switch (action) {
		default:
			HttpSession session = request.getSession();
			// dao = new InventoryDAO();
			List<InventoryItem> allItem = InventoryDAO.getAllItems();
			session.setAttribute("inventory", allItem);
			RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/jsp/manage-inventory.jsp");
			disp.forward(request, response);
			// response.sendRedirect("manage-inventory.jsp");
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		List<InventoryItem> allItem = InventoryDAO.getAllItems();
		InventoryItem itemAction = null;
		PrintWriter out = response.getWriter();

		for (InventoryItem item : allItem) {
			if (item.getProduct().getId().equals(request.getParameter("id"))) {
				itemAction = item;
				break;
			}
		}

		switch (action) {
		case "update":
			if (itemAction != null) {
				itemAction.getProduct().setPrice(Double.parseDouble(request.getParameter("price")));
				itemAction.setQuantity(Integer.parseInt(request.getParameter("quantity")));
				try {
					out.print(mapper.writeValueAsString(itemAction.getProduct()));
				} catch (JsonGenerationException e) {
					e.printStackTrace();
				}
			} else {
				out.print("");
			}
			break;
		case "delete":
			boolean success = false;
			String id = "";
			if (itemAction != null) {
				id = itemAction.getProduct().getId();
				success = InventoryDAO.getInventory().remove(itemAction.getProduct().getId(), itemAction);
				out.print(success ? "Deleted," + id : "Can't," + id);
			} else {
				out.print("");
			}
			break;
		case "create":
			int qty = Integer.parseInt(request.getParameter("quantity"));
			String param = request.getParameter("product");
			try {
				Product prod = mapper.readValue(param, Product.class);
				if (prod.getId().isEmpty()) {
					prod.setId(InventoryDAO.genId());
					prod.setImgName("noimage.jpg");
				}
				InventoryDAO.getInventory().put(prod.getId(), new InventoryItem(prod, qty));
				try {
					out.print(mapper.writeValueAsString(prod));
				} catch (JsonGenerationException e) {
					e.printStackTrace();
				}
			} catch (JsonGenerationException e) {
				e.printStackTrace();
			}
			break;
		}
	}

}
