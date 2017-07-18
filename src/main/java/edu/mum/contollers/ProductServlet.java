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

import edu.mum.models.InventoryDAO;
import edu.mum.models.InventoryItem;
import edu.mum.models.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    InventoryDAO dao;
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        dao = new InventoryDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().setAttribute("items", dao.getAllItems());
        request.getRequestDispatcher("WEB-INF/jsp/product.jsp").forward(request, response);
        ;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        Product product = new Product();
        product.setName(request.getParameter("name"));
        product.setPrice(Double.valueOf(request.getParameter("price")));
        product.setId(dao.genId());
        dao.addItem(new InventoryItem(product, 10));

        PrintWriter out = response.getWriter();
        try {
            out.print(mapper.writeValueAsString(product));
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        }
    }

}
