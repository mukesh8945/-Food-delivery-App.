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

@WebServlet("/signUpForm")
public class SignUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter(); 

        String Username = req.getParameter("Username");
        String password = req.getParameter("Password");
        String email = req.getParameter("Email");
        String address = req.getParameter("Address");
        String role = req.getParameter("role");

        try {
            // Connect to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_deliveryapp", "root",
                    "root");

            // Prepare and execute SQL query
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO user(`Username`, `Password`, `Email`, `Address`, `Role`) VALUES(?,?,?,?,?)");

            ps.setString(1, Username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, address);
            ps.setString(5, role);

            int count = ps.executeUpdate();

            resp.setContentType("text/html");

            if (count > 0) {
                out.println("<h3 style=color:green>User registration successful</h3>");
                RequestDispatcher rd = req.getRequestDispatcher("/Success.jsp");
                rd.include(req, resp);
            } else {
                req.setAttribute("registrationError", "User registration unsuccessful");
                RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
                rd.include(req, resp);
            }
        } catch (SQLException se) {
            se.printStackTrace();
            req.setAttribute("registrationError", "SQL error occurred during registration");
            RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
            rd.include(req, resp);
        } catch (ClassNotFoundException ce) {
            ce.printStackTrace();
            req.setAttribute("registrationError", "Class not found during registration");
            RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
            rd.include(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("registrationError", "User registration unsuccessful");
            RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
            rd.include(req, resp);
        }

    }
}
