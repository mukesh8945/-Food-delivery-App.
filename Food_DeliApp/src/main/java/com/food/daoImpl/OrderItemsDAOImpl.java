package com.food.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.OrderItemsDAO;
import com.food.model.OrderItems;
import com.food.model.OrderItems.OrderItem;

public class OrderItemsDAOImpl implements OrderItemsDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/fooddeliveryapp";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";

    private static final String INSERT_ORDER_ITEM = "INSERT INTO order_items (ItemTotal, Quantity, OrderID, MenuID) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ORDER_ITEM_BY_ID = "SELECT * FROM order_items WHERE OrderItemID = ?";
    private static final String UPDATE_ORDER_ITEM = "UPDATE order_items SET ItemTotal = ?, Quantity = ?, OrderID = ?, MenuID = ? WHERE OrderItemID = ?";
    private static final String DELETE_ORDER_ITEM = "DELETE FROM order_items WHERE OrderItemID = ?";
    private static final String SELECT_ORDER_ITEMS_BY_ORDER = "SELECT * FROM order_items WHERE OrderID = ?";

    @Override
    public void addOrderItem(OrderItem orderItem) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_ITEM)) {

            preparedStatement.setDouble(1, orderItem.getItemTotal());
            preparedStatement.setInt(2, orderItem.getQuantity());
            preparedStatement.setInt(3, orderItem.getOrderID());
            preparedStatement.setInt(4, orderItem.getMenuID());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public OrderItem getOrderItem(int orderItemID) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_ITEM_BY_ID)) {

            preparedStatement.setInt(1, orderItemID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return mapResultSetToOrderItem(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateOrderItem(OrderItem orderItem) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDER_ITEM)) {

            preparedStatement.setDouble(1, orderItem.getItemTotal());
            preparedStatement.setInt(2, orderItem.getQuantity());
            preparedStatement.setInt(3, orderItem.getOrderID());
            preparedStatement.setInt(4, orderItem.getMenuID());
            preparedStatement.setInt(5, orderItem.getOrderItemID());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderItem(int orderItemID) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER_ITEM)) {

            preparedStatement.setInt(1, orderItemID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderItem> getOrderItemsByOrder(int orderID) {
        List<OrderItem> orderItems = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_ITEMS_BY_ORDER)) {

            preparedStatement.setInt(1, orderID);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                orderItems.add(mapResultSetToOrderItem(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderItems;
    }

    private OrderItem mapResultSetToOrderItem(ResultSet resultSet) throws SQLException {
        OrderItems<OrderItem> orderItems = new OrderItems<>();
        OrderItem orderItem = orderItems.new OrderItem();
        orderItem.setOrderItemID(resultSet.getInt("OrderItemID"));
        orderItem.setItemTotal(resultSet.getDouble("ItemTotal"));
        orderItem.setQuantity(resultSet.getInt("Quantity"));
        orderItem.setOrderID(resultSet.getInt("OrderID"));
        orderItem.setMenuID(resultSet.getInt("MenuID"));
        return orderItem;
    }

}
