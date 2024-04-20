package com.food.dao;

import java.util.List;

import com.food.model.OrderItems.OrderItem;

public interface OrderItemsDAO {
	void addOrderItem(OrderItem orderItem);
	OrderItem getOrderItem(int orderItemId);
	void updateOrderItem(OrderItem orderItemId);
	void deleteOrderItem(int orderItemId);
	List<OrderItem> getOrderItemsByOrder(int orderId);
}
