package com.food.model;

import java.awt.im.spi.InputMethod;

import java.util.Date;
import java.util.List;

import com.food.model.OrderItems.OrderItem;

public class Order<OrderStatus> {

	private Long orderID;
	private int userId;
	private Long restaurantId;
	private Date orderDate;
	private Double totalAmount;
	private OrderStatus status;
	private String paymentMethod;
	private List<OrderItem> orderItems;
	public Long getOrderID() {
		return orderID;
	}
	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	/**
	 * 
	 */
	public Order() {
		super();
	}
	/**
	 * @param orderID
	 * @param userId
	 * @param restaurantId
	 * @param orderDate
	 * @param totalAmount
	 * @param status
	 * @param paymentMethod
	 * @param orderItems
	 */
	public Order(Long orderID, int userId, Long restaurantId, Date orderDate, Double totalAmount, OrderStatus status,
			String paymentMethod, List<OrderItem> orderItems) {
		super();
		this.orderID = orderID;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMethod = paymentMethod;
		this.orderItems = orderItems;
	}
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", userId=" + userId + ", restaurantId=" + restaurantId + ", orderDate="
				+ orderDate + ", totalAmount=" + totalAmount + ", status=" + status + ", paymentMethod=" + paymentMethod
				+ ", orderItems=" + orderItems + "]";
	}
}