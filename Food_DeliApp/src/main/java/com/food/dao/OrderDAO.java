package com.food.dao;

import java.util.List;

import com.food.model.Order;
//import com.food.DAOImp.OrderHistory;

public interface OrderDAO {
		void addOrder(Order order);
		Order getOrder(int orderId);
		void updateOrdate(Order order);
		void deleteOrder(int orderId);
		List<Order> getAllOrderByUser(int userId);
		OrderHistoryDAO getOrderHistoryById(int orderHistoryId);
}
