 package com.food.model;

import java.awt.Menu;
import java.util.List;


public class Restaurant {
    private Long restaurantID;
    private String name;
    private String cuisineType;
    private Integer deliveryTime;
    private String address;
    private int adminUserID;
    private Double rating;
    private Boolean isActive;
    private String imagePath;
    private List<Menu> menuItems;

	public Long getRestaurantID() {
		return restaurantID;
	}

	public void setRestaurantID(Long restaurantID) {
		this.restaurantID = restaurantID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public Integer getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Integer deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAdminUserID() {
		return adminUserID;
	}

	public void setAdminUserID(int adminUserID) {
		this.adminUserID = adminUserID;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public List<Menu> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<Menu> menuItems) {
		this.menuItems = menuItems;
	}

	
	public Restaurant(long restaurantID, String name, String cuisineType, Integer deliveryTime, String address,
			int adminUserID, Double rating, Boolean isActive, String imagePath, List<Menu> menuItems) {
		super();
		this.restaurantID = restaurantID;
		this.name = name;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.address = address;
		this.adminUserID = adminUserID;
		this.rating = rating;
		this.isActive = isActive;
		this.imagePath = imagePath;
		this.menuItems = menuItems;
	}

	
	public Restaurant() {
		super();
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantID=" + restaurantID + ", name=" + name + ", cuisineType=" + cuisineType
				+ ", deliveryTime=" + deliveryTime + ", address=" + address + ", adminUserID=" + adminUserID
				+ ", rating=" + rating + ", isActive=" + isActive + ", imagePath=" + imagePath + ", menuItems="
				+ menuItems + "]";
	}
	
	
	
}
