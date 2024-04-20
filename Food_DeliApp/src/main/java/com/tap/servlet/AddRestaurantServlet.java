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

@WebServlet("/AddRestaurantServlet")
public class AddRestaurantServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		String name = req.getParameter("name");
		String cuisineType = req.getParameter("cuisineType");
		int deliveryTime = Integer.parseInt(req.getParameter("deliveryTime"));
		String address = req.getParameter("address");
		int adminUserId = Integer.parseInt(req.getParameter("adminUserId"));
		double rating = Double.parseDouble(req.getParameter("rating"));
		boolean isActive = req.getParameter("isActive") != null;
		String imagePath = req.getParameter("imagePath");

		try {
			// Connect to the database using try-with-resources
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_deliveryapp", "root",
					"root")) {
				// Prepare and execute SQL query with placeholders
				String sql = "INSERT INTO restaurant(Name, CuisineType, DeliveryTime, Address, AdminUserID, Rating, IsActive, ImagePath) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
				try (PreparedStatement ps = con.prepareStatement(sql)) {
					ps.setString(1, name);
					ps.setString(2, cuisineType);
					ps.setInt(3, deliveryTime);
					ps.setString(4, address);
					ps.setInt(5, adminUserId);
					ps.setDouble(6, rating);
					ps.setBoolean(7, isActive);
					ps.setString(8, imagePath);

					int count = ps.executeUpdate();

					resp.setContentType("text/html");

					if (count > 0) {
						out.println("<h3 style=color:green>Restaurant added successfully</h3>");
						RequestDispatcher rd = req.getRequestDispatcher("/Success.jsp");
						rd.include(req, resp);
					} else {
						req.setAttribute("registrationError", "Restaurant addition unsuccessful");
						RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
						rd.include(req, resp);
					}
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			req.setAttribute("registrationError", "An error occurred during restaurant addition");
			RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
			rd.include(req, resp);
		}
	}
}
