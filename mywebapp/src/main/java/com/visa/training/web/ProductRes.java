package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.visa.training.jdbc.Product;
import com.visa.training.jdbc.ProductDAO;

@WebServlet("/product")
public class ProductRes extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("n");
		String price = request.getParameter("p");
		String qOh = request.getParameter("qoh");
		int pr = Integer.parseInt(price);
		int qoh = Integer.parseInt(qOh);
		Product p = new Product(name, pr, qoh);
		ProductDAO pd = new ProductDAO();
		pd.save(p);
		PrintWriter out = response.getWriter();
		out.println("inserted");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
