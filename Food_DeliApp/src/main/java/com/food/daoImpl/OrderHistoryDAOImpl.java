package com.food.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.food.dao.OrderHistoryDAO;
import com.food.model.OrderHistory;
import com.food.model.User; // Import the User class if not already imported

public abstract class OrderHistoryDAOImpl implements OrderHistoryDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/fooddeliveryapp";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";

    private static final String INSERT_ORDER_HISTORY = "INSERT INTO order_history (User_ID, Order_ID, OrderDate, TotalAmount, Status) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ORDER_HISTORY_BY_ID = "SELECT * FROM order_history WHERE OrderHistoryID = ?";
    private static final String UPDATE_ORDER_HISTORY = "UPDATE order_history SET User_ID = ?, Order_ID = ?, OrderDate = ?, TotalAmount = ?, Status = ? WHERE OrderHistoryID = ?";
    private static final String DELETE_ORDER_HISTORY = "DELETE FROM order_history WHERE OrderHistoryID = ?";
    private static final String SELECT_ORDER_HISTORY_BY_USER = "SELECT * FROM order_history WHERE User_ID = ?";

    @Override
    public void addOrderHistory(OrderHistory orderHistory) {
        // Your implementation remains the same
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_HISTORY)) {

            preparedStatement.setInt(1, orderHistory.getUser().getUserID());
            preparedStatement.setInt(2, orderHistory.getOrderID());
            preparedStatement.setDate(3, new java.sql.Date(orderHistory.getOrderDate().getTime()));
            preparedStatement.setDouble(4, orderHistory.getTotalAmount());
            preparedStatement.setString(5, orderHistory.getStatus());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public OrderHistory<String> getOrderHistory(int orderHistoryId) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_HISTORY_BY_ID)) {

            preparedStatement.setInt(1, orderHistoryId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return mapResultSetToOrderHistory(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateOrderHistory(OrderHistory orderHistory) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDER_HISTORY)) {

            preparedStatement.setInt(1, orderHistory.getUser().getUserID());
            preparedStatement.setInt(2, orderHistory.getOrderID());
            preparedStatement.setDate(3, new java.sql.Date(orderHistory.getOrderDate().getTime()));
            preparedStatement.setDouble(4, orderHistory.getTotalAmount());
            preparedStatement.setString(5, orderHistory.getStatus());
            preparedStatement.setLong(6, orderHistory.getOrderHistoryID());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderHistory(int orderHistoryId) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER_HISTORY)) {

            preparedStatement.setInt(1, orderHistoryId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderHistory> getOrderHistoryByUser(int userId) {
        List<OrderHistory> orderHistories = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_HISTORY_BY_USER)) {

            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                orderHistories.add(mapResultSetToOrderHistory(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderHistories;
    }


    private OrderHistory<String> mapResultSetToOrderHistory(ResultSet resultSet) throws SQLException {
        OrderHistory<String> orderHistory = new OrderHistory<>();
        orderHistory.setOrderHistoryID(resultSet.getLong("OrderHistoryID"));
        // Set other properties based on resultSet
        return orderHistory;
    }
}
