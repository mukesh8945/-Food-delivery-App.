package com.food.dao;

import java.awt.Menu;
import java.util.List;

public interface MenuDAO {
	void addMenu(Menu menu);
	Menu getMenu(int menuId);
	void updateMenu(Menu menu);
	void deleteMenu(int menuId);
	List<com.food.model.Menu> getAllMenuByRestaurant(int restaurantId);
	//List<com.food.model.Menu> getAllMenuByRestaurant(int restaurantId);
	//com.food.model.Menu getMenuByMenuId(int itemId);
	com.food.model.Menu getMenuByMenuId(int itemId);
	
}
