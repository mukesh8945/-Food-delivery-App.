package com.food.model;

public class OrderItems<OrderTable> {
	public class OrderItem {

		private int OrderItemID;
		private Double ItemTotal;
		private Integer Quantity;
		private int OrderID;
		private int MenuID;

		public int getOrderItemID() {
			return OrderItemID;
		}

		public void setOrderItemID(int orderItemID) {
			OrderItemID = orderItemID;
		}

		public Double getItemTotal() {
			return ItemTotal;
		}

		public void setItemTotal(Double itemTotal) {
			ItemTotal = itemTotal;
		}

		public Integer getQuantity() {
			return Quantity;
		}

		public void setQuantity(Integer quantity) {
			Quantity = quantity;
		}

		public int getOrderID() {
			return OrderID;
		}

		public void setOrderID(int orderID) {
			OrderID = orderID;
		}

		public int getMenuID() {
			return MenuID;
		}

		public void setMenuID(int menuID) {
			MenuID = menuID;
		}

	
		public OrderItem(int orderItemID, Double itemTotal, Integer quantity, int orderID, int menuID) {
			super();
			OrderItemID = orderItemID;
			ItemTotal = itemTotal;
			Quantity = quantity;
			OrderID = orderID;
			MenuID = menuID;
		}

	
		public OrderItem() {
			super();
		}

		@Override
		public String toString() {
			return "OrderItem [OrderItemID=" + OrderItemID + ", ItemTotal=" + ItemTotal + ", Quantity=" + Quantity
					+ ", OrderID=" + OrderID + ", MenuID=" + MenuID + "]";
		}

	}

}
