package com.fod.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import com.fod.DAO.OrderHistoryDAO;
import com.fod.ddutils.DBUtils;
import com.fod.model.orderHistory;

public class OrderHistoryDAOImpl implements OrderHistoryDAO {
    Connection con;
    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet resultSet;
    List<orderHistory> orderHistoryList = new ArrayList<>();
    int status = 0;
    private orderHistory orderHistory;

    // SQL Queries
    private static final String ADD_ORDER_HISTORY = "INSERT INTO `orderhistory` (orderId, userId,  totalAmount, status) VALUES (?, ?, ?, ?)";
    private static final String GET_ALL_ORDER_HISTORY = "SELECT * FROM `orderhistory`";
    private static final String GET_ORDER_HISTORY_BY_ID = "SELECT * FROM `orderhistory` WHERE `orderhistoryId` = ?";
    private static final String GET_ORDER_HISTORY_BYUSERID="SELECT * FROM `orderhistory` where `userId`=?";
    public OrderHistoryDAOImpl() {
        try {
            con = DBUtils.myConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to add order history
    @Override
    public int addOrderHistory(orderHistory OH) {
        try {
            pstmt = con.prepareStatement(ADD_ORDER_HISTORY);
            pstmt.setInt(1, OH.getOrderId());
            pstmt.setInt(2, OH.getUserId());
            pstmt.setFloat(3, OH.getTotalAmount());
            pstmt.setString(4, OH.getStatus());
            status = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    // Method to get all order histories
    @Override
    public List<orderHistory> getAllOrderHistory() {
        try {
            stmt = con.createStatement();
            resultSet = stmt.executeQuery(GET_ALL_ORDER_HISTORY);
            orderHistoryList = extractOrderHistoryFromResultSet(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderHistoryList;
    }

    // Method to get order history by ID
    @Override
    public orderHistory getOrderHistoryById(int orderHistoryId) {
        try {
            pstmt = con.prepareStatement(GET_ORDER_HISTORY_BY_ID);
            pstmt.setInt(1, orderHistoryId);
            resultSet = pstmt.executeQuery();
            orderHistoryList = extractOrderHistoryFromResultSet(resultSet);
            if (!orderHistoryList.isEmpty()) {
                orderHistory = orderHistoryList.get(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderHistory;
    }

    // Method to extract data from ResultSet
    List<orderHistory> extractOrderHistoryFromResultSet(ResultSet resultSet) {
        List<orderHistory> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                list.add(new orderHistory(
                        resultSet.getInt("orderhistoryId"),
                        resultSet.getInt("orderId"),
                        resultSet.getInt("userId"),
                        resultSet.getTimestamp("orderDate"),
                        resultSet.getFloat("totalAmount"),
                        resultSet.getString("status")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

	@Override
	public List<orderHistory> getAllOrderHistoryonUserID(int userid) {
		try {
			pstmt = con.prepareStatement(GET_ORDER_HISTORY_BYUSERID);
			pstmt.setInt(1, userid);
			resultSet=pstmt.executeQuery();
			 orderHistoryList = extractOrderHistoryFromResultSet(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orderHistoryList;
	}
}
