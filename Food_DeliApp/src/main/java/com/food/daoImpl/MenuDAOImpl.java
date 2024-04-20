package com.food.daoImpl;

import com.food.dao.MenuDAO;
import com.food.model.Menu;
import com.food.model.Restaurant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuDAOImpl implements MenuDAO {
    static {
        try {
            // Explicitly load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/food_deliveryapp";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";

    private static final String SELECT_MENU_BY_MENU_ID = "SELECT * FROM menu WHERE MenuID = ?";
    private static final String INSERT_MENU = "INSERT INTO menu (`RestaurantID`, `ItemName`, `Description`, `Price`, `IsAvailable`,`ratings`,`ImagePath`) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_MENU = "UPDATE menu SET RestaurantID = ?, ItemName = ?, Description = ?, Price = ?, IsAvailable = ?,ratings=?, ImagePath=? WHERE MenuID = ?";
    private static final String DELETE_MENU = "DELETE FROM menu WHERE MenuID = ?";
    private static final String SELECT_ALL_MENU = "SELECT * FROM menu WHERE RestaurantID = ?";

    public Menu getMenuByMenuId(int menuId) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MENU_BY_MENU_ID)) {

            preparedStatement.setLong(1, menuId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return mapResultSetToMenu(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addMenu(Menu menu) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MENU,
                     Statement.RETURN_GENERATED_KEYS)) {

            setMenuParameters(preparedStatement, menu);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    menu.setMenuID(generatedKeys.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMenu(Menu menu) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MENU)) {

            setMenuParameters(preparedStatement, menu);
            preparedStatement.setLong(7, menu.getMenuID());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMenu(Long menuId) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MENU)) {

            preparedStatement.setLong(1, menuId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Menu> getAllMenus() {
        List<Menu> menus = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MENU);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                menus.add(mapResultSetToMenu(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menus;
    }

    @Override
    public List<Menu> getAllMenuByRestaurant(int restaurantId) {
        List<Menu> menus = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MENU)) {

            preparedStatement.setInt(1, restaurantId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                menus.add(mapResultSetToMenu(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menus;
    }

    private Menu mapResultSetToMenu(ResultSet resultSet) throws SQLException {
        Menu menu = new Menu();
        menu.setMenuID(resultSet.getInt("MenuID"));
        menu.setRestaurantId(mapResultSetToRestaurantId(resultSet));
        menu.setItemName(resultSet.getString("ItemName"));
        menu.setDescription(resultSet.getString("Description"));
        menu.setPrice(resultSet.getDouble("Price"));
        menu.setIsAvailable(resultSet.getBoolean("IsAvailable"));
        menu.setImagePath(resultSet.getString("ImagePath"));
        return menu;
    }

    private int mapResultSetToRestaurantId(ResultSet resultSet) {
		// TODO Auto-generated method stub
		return 0;
	}

	private Restaurant mapResultSetToRestaurant(ResultSet resultSet) throws SQLException {
        // Assuming you have a Restaurant class with appropriate methods
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantID(resultSet.getLong("RestaurantID"));
        // Set other properties as needed
        return restaurant;
    }

    private void setMenuParameters(PreparedStatement preparedStatement, Menu menu) throws SQLException {
        preparedStatement.setLong(1, menu.getRestaurantId());
        preparedStatement.setString(2, menu.getItemName());
        preparedStatement.setString(3, menu.getDescription());
        preparedStatement.setDouble(4, menu.getPrice());
        preparedStatement.setBoolean(5, menu.getIsAvailable());
         preparedStatement.setString(7, menu.getImagePath());
    }

    @Override
    public void addMenu(java.awt.Menu menu) {
        // TODO Auto-generated method stub

    }

    @Override
    public java.awt.Menu getMenu(int menuId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateMenu(java.awt.Menu menu) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteMenu(int menuId) {
        // TODO Auto-generated method stub

    }
}
