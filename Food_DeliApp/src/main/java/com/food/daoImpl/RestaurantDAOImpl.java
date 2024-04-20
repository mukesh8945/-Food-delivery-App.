
package com.food.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.RestaurantDAO;
import com.food.model.Restaurant;

public  class RestaurantDAOImpl implements RestaurantDAO {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/food_deliveryapp";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "root";

	private static final String SELECT_RESTAURANT_BY_ID = "SELECT * FROM restaurant WHERE RestaurantId = ?";
	private static final String INSERT_RESTAURANT = "INSERT INTO restaurant (Name, CuisineType, DeliveryTime, Address, AdminUserId, Rating, IsActive, ImagePath) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_RESTAURANT = "UPDATE restaurant SET Name = ?, CuisineType = ?, DeliveryTime = ?, Address = ?, AdminUserId = ?, Rating = ?, IsActive = ?, ImagePath = ? WHERE RestaurantId = ?";
	private static final String DELETE_RESTAURANT = "DELETE FROM restaurant WHERE RestaurantId = ?";
	private static final String SELECT_ALL_RESTAURANTS = "SELECT * FROM restaurant";

	@Override
	public Restaurant getRestaurantById(int restaurantId) {
		try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RESTAURANT_BY_ID);) {
			preparedStatement.setInt(1, restaurantId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return mapResultSetToRestaurant(resultSet);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addRestaurant(Restaurant restaurant) {
		try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RESTAURANT)) {

			setRestaurantParameters(preparedStatement, restaurant);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_RESTAURANT)) {

			setRestaurantParameters(preparedStatement, restaurant);
			preparedStatement.setFloat(9, restaurant.getRestaurantID());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_RESTAURANT)) {

			preparedStatement.setInt(1, restaurantId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		List<Restaurant> restaurants = new ArrayList<>();

		
		 try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		    } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		        // Handle the exception or throw it if necessary
		    }
		 
		try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RESTAURANTS);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				restaurants.add(mapResultSetToRestaurant(resultSet));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return restaurants;
	}

	private Restaurant mapResultSetToRestaurant(ResultSet resultSet) throws SQLException {
		return new Restaurant(resultSet.getInt("RestaurantId"), resultSet.getString("Name"),
				resultSet.getString("CuisineType"), resultSet.getInt("DeliveryTime"), resultSet.getString("Address"),
				resultSet.getInt("AdminUserId"), resultSet.getDouble("Rating"), resultSet.getBoolean("IsActive"),
				resultSet.getString("ImagePath"), null // Assuming that the menu items list is not retrieved in this
														// method
		);
	}

	private void setRestaurantParameters(PreparedStatement preparedStatement, Restaurant restaurant)
			throws SQLException {
		preparedStatement.setString(1, restaurant.getName());
		preparedStatement.setString(2, restaurant.getCuisineType());
		preparedStatement.setInt(3, restaurant.getDeliveryTime());
		preparedStatement.setString(4, restaurant.getAddress());
		preparedStatement.setInt(5, restaurant.getAdminUserID());
		preparedStatement.setDouble(6, restaurant.getRating());
		preparedStatement.setBoolean(7, restaurant.getIsActive());
		preparedStatement.setString(8, restaurant.getImagePath());
	}

	@Override
	public Restaurant getRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		// TODO Auto-generated method stub
		return null;
	}
}
