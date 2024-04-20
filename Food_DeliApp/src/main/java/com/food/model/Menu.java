package com.food.model;

public class Menu {

	private int menuID;
	private int restaurantId;
	private String itemName;
	private String description;
	private Double price;
	private Boolean isAvailable;
	private String imagePath;
	
	public int getMenuID() {
		return menuID;
	}
	public void setMenuID(int menuID) {
		this.menuID = menuID;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	/**
	 * 
	 */
	public Menu() {
		super();
	}
	
	public Menu(int menuID, int restaurantId, String itemName, String description, Double price, Boolean isAvailable,
			String imagePath) {
		super();
		this.menuID = menuID;
		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.imagePath = imagePath;
	}
	@Override
	public String toString() {
		return "Menu [menuID=" + menuID + ", restaurantId=" + restaurantId + ", itemName=" + itemName + ", description="
				+ description + ", price=" + price + ", isAvailable=" + isAvailable + ", imagePath=" + imagePath + "]";
	}
	
	
}
