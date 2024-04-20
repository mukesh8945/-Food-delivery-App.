package com.food.daoImpl;

import com.food.dao.OrderDAO;
import com.food.dao.OrderHistoryDAO;
import com.food.model.Order;
import com.food.model.OrderItems.OrderItem;
import com.food.model.Restaurant;
import com.food.model.User;

import java.awt.im.spi.InputMethod;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public  class OrderDAOImpl<OrderStatus> implements OrderDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/fooddeliveryapp";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";

    private static final String SELECT_ORDER_BY_ID = "SELECT * FROM orders WHERE OrderID = ?";
    private static final String INSERT_ORDER = "INSERT INTO orders (UserID, RestaurantID, OrderDate, TotalAmount, Status, PaymentMethod) VALUES (?, ?, CURRENT_TIMESTAMP, ?, ?, ?)";
    private static final String UPDATE_ORDER = "UPDATE orders SET UserID = ?, RestaurantID = ?, OrderDate = ?, TotalAmount = ?, Status = ?, PaymentMethod = ? WHERE OrderID = ?";
    private static final String DELETE_ORDER = "DELETE FROM orders WHERE OrderID = ?";
    private static final String SELECT_ALL_ORDERS = "SELECT * FROM orders";

    @Override
    public Order getOrder(int orderId) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_BY_ID)) {

            preparedStatement.setInt(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return mapResultSetToOrder(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addOrder(Order order) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER, Statement.RETURN_GENERATED_KEYS)) {

            setOrderParameters(preparedStatement, order);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    order.setOrderID(generatedKeys.getLong(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrdate(Order order) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDER)) {

            setOrderParameters(preparedStatement, order);
            preparedStatement.setLong(7, order.getOrderID());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(int orderId) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER)) {

            preparedStatement.setInt(1, orderId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> getAllOrderByUser(int userId) {
        List<Order> orders = new ArrayList<>();

        // Implement the logic to retrieve orders by user ID

        return orders;
    }

    // Other methods of the interface

    private Order mapResultSetToOrder(ResultSet resultSet) throws SQLException {
        Order order = new Order();
        order.setOrderID(resultSet.getLong("OrderID"));
        order.setUserId(resultSet.getInt("UserID"));
        order.setRestaurantId(resultSet.getLong("RestaurantID"));
        order.setOrderDate(resultSet.getDate("OrderDate"));
        order.setTotalAmount(resultSet.getDouble("TotalAmount"));
        // Assuming you have appropriate methods in OrderStatus enum
         order.setStatus((OrderStatus) resultSet.getObject("Status"));
        // Assuming you have appropriate methods in InputMethod enum
         order.setPaymentMethod((String) resultSet.getObject("PaymentMethod"));
        return order;
    }

    private void setOrderParameters(PreparedStatement preparedStatement, Order order) throws SQLException {
        preparedStatement.setInt(1, order.getUserId());
        preparedStatement.setLong(2, order.getRestaurantId());
        preparedStatement.setDouble(3, order.getTotalAmount());
        // Set other parameters as needed
    }

	@Override
	public OrderHistoryDAO getOrderHistoryById(int orderHistoryId) {
		// TODO Auto-generated method stub
		return null;
	}
}
