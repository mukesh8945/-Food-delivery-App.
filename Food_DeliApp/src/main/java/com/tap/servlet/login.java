
package com.tap.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginForm")
public class login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("Username");
        String password = req.getParameter("Password");

        try {
            // Connect to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_deliveryapp", "root",
                    "root");

            // Prepare and execute SQL query
            String sql = "SELECT * FROM user WHERE Username=? AND Password=?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, username);
                ps.setString(2, password);

                try (ResultSet rs = ps.executeQuery()) {
                    resp.setContentType("text/html");

                    if (rs.next()) {
                       HttpSession session=req.getSession();
                       session.setAttribute("Username", rs.getString("Username"));
                        RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
                        rd.include(req, resp);
                    } else {
                        req.setAttribute("registrationError", "Login unsuccessful");
                        RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
                        rd.include(req, resp);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            req.setAttribute("registrationError", "An error occurred during login");
            RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
            rd.include(req, resp);
        }
    }
}

