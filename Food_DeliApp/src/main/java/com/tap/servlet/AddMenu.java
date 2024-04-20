package com.tap.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddMenuServlet")
public class AddMenu extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		Long restaurantId = Long.parseLong(req.getParameter("restaurantId"));
		String itemName = req.getParameter("itemName");
		String description = req.getParameter("description");
		double price = Double.parseDouble(req.getParameter("price"));
		boolean isAvailable = req.getParameter("isAvailable") != null;
		String imagePath = req.getParameter("imagePath");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_deliveryapp", "root",
					"root")) {
				String sql = "INSERT INTO menu (RestaurantID, ItemName, Description, Price, IsAvailable, ImagePath) VALUES (?, ?, ?, ?, ?, ?)";
				try (PreparedStatement ps = con.prepareStatement(sql)) {
					ps.setLong(1, restaurantId);
					ps.setString(2, itemName);
					ps.setString(3, description);
					ps.setDouble(4, price);
					ps.setBoolean(5, isAvailable);
					ps.setString(6, imagePath);

					int count = ps.executeUpdate();

					resp.setContentType("text/html");

					if (count > 0) {
						out.println("<h3 style=color:green>Menu added successfully</h3>");
						RequestDispatcher rd = req.getRequestDispatcher("/Success.jsp");
						rd.include(req, resp);
					} else {
						req.setAttribute("registrationError", "Menu addition unsuccessful");
						RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
						rd.include(req, resp);
					}
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			req.setAttribute("registrationError", "An error occurred during menu addition");
			RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
			rd.include(req, resp);
		}
	}
}
