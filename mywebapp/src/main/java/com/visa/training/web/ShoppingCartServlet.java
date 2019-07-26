package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({ "/addbooks", "/addcars", "/addbiikes" })
public class ShoppingCartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String uri = request.getRequestURI();
		if (uri.endsWith("addbooks")) {
			String[] selectedBooks = request.getParameterValues("books");
			session.setAttribute("selectedBooks", selectedBooks);
			request.getRequestDispatcher("cars.html").forward(request, response);

		} else if (uri.endsWith("addcars")) {
			String[] selectedCars = request.getParameterValues("cars");
			session.setAttribute("selectedCars", selectedCars);
			request.getRequestDispatcher("bikes.html").forward(request, response);

		} else if (uri.endsWith("addbiikes")) {
			String[] selectedBikes = request.getParameterValues("bikes");
			String[] selectedBooks = (String[]) session.getAttribute("selectedBooks");
			String[] selectedCars = (String[]) session.getAttribute("selectedCars");
		
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		/*	PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<h4>SelectedBooks</h4>");
			out.println("<ul>");
			Stream.of(selectedBooks).map(s -> "<li>" + s + "</li>").forEach(out::println);
			out.println("</ul");
			out.println("<h4>SelectedCars</h4>");
			out.println("<ul>");
			Stream.of(selectedCars).map(s -> "<li>" + s + "</li>").forEach(out::println);
			out.println("</ul");
			out.println("<h4>SelectedBikes</h4>");
			out.println("<ul>");
			Stream.of(selectedBikes).map(s -> "<li>" + s + "</li>").forEach(out::println);
			out.println("</ul");

			out.println("</body></html>");
			*/
			//session.invalidate();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
