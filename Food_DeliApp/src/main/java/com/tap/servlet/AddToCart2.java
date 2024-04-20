package com.tap.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.dao.MenuDAO;
import com.food.daoImpl.MenuDAOImpl;
import com.food.model.Cart;
import com.food.model.CartItem;
import com.food.model.Menu;

//@WebServlet("/AddToCartServlet")//
public class AddToCart2 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");

		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		String action = request.getParameter("action");

		if (action != null) {
			if (action.equals("addToCart")) {
				addItemToCart(request, cart);
			} else if (action.equals("update")) {
				updateCartItem(request, cart);
			} else if (action.equals("remove")) {
				removeItemFromCart(request, cart);
			}
		}

		session.setAttribute("cart", cart);
		response.sendRedirect("AddCart.jsp");
	}

	private void addItemToCart(HttpServletRequest request, Cart cart) {
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
//Image path
		MenuDAO menuDAO = new MenuDAOImpl();
		Menu menuItem = menuDAO.getMenuByMenuId(itemId);

		HttpSession session = request.getSession();
		session.setAttribute("restaurantId", (menuItem != null) ? menuItem.getRestaurantId() : null);

		if (menuItem != null) {
			CartItem item = new CartItem(menuItem.getMenuID(), menuItem.getRestaurantId(), menuItem.getItemName(),
					quantity, menuItem.getPrice());
			cart.addItem(item);
		}
	}

	private void updateCartItem(HttpServletRequest request, Cart cart) {
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		cart.updateItem(itemId, quantity);
	}

	private void removeItemFromCart(HttpServletRequest request, Cart cart) {
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		cart.removeItem(itemId);
	}
}
