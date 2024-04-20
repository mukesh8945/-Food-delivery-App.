package com.food.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {


	    private Map<Integer, CartItem> items;

	    public Cart() {
	        items = new HashMap<>();
	    }

	    public void addItem(CartItem newItem) {
	        int itemId = newItem.getItemId();

	        if (items.containsKey(itemId)) {
	            CartItem existingItem = items.get(itemId);
	            existingItem.setQuantity(existingItem.getQuantity() + newItem.getQuantity());
	        } else {
	            items.put(itemId, newItem);
	        }
	    }

	    public void updateItem(int itemId, int quantity) {
	        if (items.containsKey(itemId)) {
	            CartItem existingItem = items.get(itemId);
	            existingItem.setQuantity(quantity);
	        }
	    }

	    public void removeItem(int itemId) {
	        items.remove(itemId);
	    }

	    public Map<Integer, CartItem> getItems() {
	        return items;
	    }
	    public void clear() {
			items.clear();
		}  
	}