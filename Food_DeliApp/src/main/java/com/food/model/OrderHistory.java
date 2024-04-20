package com.food.model;

import java.util.Date;

public class OrderHistory<OrderStatus> {

	private Long orderHistoryID;
	private User user;
	private int orderID;
	private Date orderDate;
	private Double totalAmount;
	private String status;

	public Long getOrderHistoryID() {
		return orderHistoryID;
	}

	public void setOrderHistoryID(Long orderHistoryID) {
		this.orderHistoryID = orderHistoryID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @param orderHistoryID
	 * @param user
	 * @param orderID
	 * @param orderDate
	 * @param totalAmount
	 * @param status
	 */
	public OrderHistory(Long orderHistoryID, User user, int orderID, Date orderDate, Double totalAmount,
			String status) {
		super();
		this.orderHistoryID = orderHistoryID;
		this.user = user;
		this.orderID = orderID;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
	}

	/**
	 * 
	 */
	public OrderHistory() {
		super();
	}

	@Override
	public String toString() {
		return "OrderHistory [orderHistoryID=" + orderHistoryID + ", user=" + user + ", orderID=" + orderID
				+ ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + ", status=" + status + "]";
	}
	
	

}
