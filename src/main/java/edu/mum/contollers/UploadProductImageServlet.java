package edu.mum.contollers;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import edu.mum.dao.InventoryDAO;

@WebServlet(name = "productupload", urlPatterns = { "/UploadProductImage" })
public class UploadProductImageServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Part filePart = request.getPart("file");

		Enumeration<String> strs = request.getParameterNames();
		String productNewID = InventoryDAO.genId();
		String fileName = "product" + productNewID + ".jpg";
		Path destination = Paths.get("resources/images/" + fileName);
		InputStream fileContent = filePart.getInputStream();

		Files.copy(fileContent, destination);

		PrintWriter out = response.getWriter();
		out.print(productNewID);
	}

}
