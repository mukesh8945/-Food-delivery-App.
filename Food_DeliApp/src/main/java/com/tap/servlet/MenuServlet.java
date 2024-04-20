

package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.dao.MenuDAO;
import com.food.daoImpl.MenuDAOImpl;
import com.food.model.Menu;

@WebServlet("/Menu")
public class MenuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private MenuDAO menuDAO;

    @Override
    public void init() {
        menuDAO = new MenuDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String restaurantIdParam = request.getParameter("restaurantId");

        if (restaurantIdParam != null && !restaurantIdParam.isEmpty()) {
            try {
                int restaurantId = Integer.parseInt(restaurantIdParam);
                List<Menu> menuList = menuDAO.getAllMenuByRestaurant(restaurantId);
                request.setAttribute("menuList", menuList);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                // Handle the case where 'restaurantId' is not a valid integer
            }
        } else {
            // Handle the case where 'restaurantId' parameter is not present
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("menuPage2.jsp");
        dispatcher.forward(request, response);
    }
}
