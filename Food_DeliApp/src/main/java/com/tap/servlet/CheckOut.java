package com.tap.servlet;

import java.awt.im.spi.InputMethod;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.dao.OrderDAO;
import com.food.daoImpl.OrderDAOImpl;
import com.food.model.Cart;
import com.food.model.CartItem;
import com.food.model.Order;
import com.food.model.User;

@WebServlet("/Checkout")
public class CheckOut extends HttpServlet {

    private OrderDAO orderDAO;

    @Override
    public void init() {
        orderDAO = new OrderDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("Username");
        
        if (user != null) {
            if (cart != null && user != null && !cart.getItems().isEmpty()) {
                // Extra checkout form data
                String paymentMethod = request.getParameter("paymentmethod");

                // Create and populate the order object
                Order<String> order = new Order<>();
                order.setUserId(user.getUserID());
                // Assuming that session.getAttribute("restaurantId") returns Long
                order.setRestaurantId((Long) session.getAttribute("restaurantId"));
                order.setOrderDate(new Date(System.currentTimeMillis()));
                order.setPaymentMethod(paymentMethod);
                order.setStatus("Pending");

                // Add cart items to calculate totalAmount
                double totalAmount = 0;
                for (CartItem item : cart.getItems().values()) {
                    totalAmount += item.getPrice() * item.getQuantity();
                }
                order.setTotalAmount(totalAmount);

                // Save the order to the database
                orderDAO.addOrder(order);

                // Clear the cart and redirect to the order confirmation page
                session.removeAttribute("cart");
                session.setAttribute("order", order);
                response.sendRedirect("order_confirmation.jsp");
            } else {
                response.sendRedirect("AddCart.jsp");
            }
        } else {
            response.sendRedirect("Login.jsp");
        }
    }
}
