package com.food.dao;

import java.util.List;

import com.food.model.Restaurant;

public interface RestaurantDAO {
	void addRestaurant(Restaurant restaurant);
	Restaurant getRestaurant(Restaurant restaurant);
	void updateRestaurant(Restaurant restaurant);
	void deleteRestaurant(int restaurantId);
	 List<Restaurant> getAllRestaurant();
	List<Restaurant> getAllRestaurants();
	Restaurant getRestaurantById(int restaurantId);
}
