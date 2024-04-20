package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.daoImpl.RestaurantDAOImpl;
import com.food.model.Restaurant;

@WebServlet("/HomePage")
public class HomePage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RestaurantDAOImpl obj = new RestaurantDAOImpl();
        List<Restaurant> restaurants = obj.getAllRestaurants();

        request.setAttribute("restaurantList", restaurants);

        RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
        rd.forward(request, response);
    }
}
