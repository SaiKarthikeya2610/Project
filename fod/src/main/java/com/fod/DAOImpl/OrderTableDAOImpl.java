package com.fod.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fod.DAO.OrderTableDAO;
import com.fod.ddutils.DBUtils;
import com.fod.model.orderTable;

public class OrderTableDAOImpl implements OrderTableDAO {
    Connection con;
    private PreparedStatement pstmt;
    private ResultSet resultSet;
    int status = 0;

    private static final String GET_MAX_ORDERID = "SELECT MAX(ordertableId) AS max_order_id FROM ordertable";
    private static final String ADD_ORDER_TABLE = "INSERT INTO ordertable(`restaurantId`, `userId`, `paymentMode`,  `totalAmount`, `status`) VALUES(?, ?, ?, ?, ?)";
    private static final String GET_ALL_ORDER_TABLE = "SELECT * FROM `ordertable`";
    private static final String GET_ORDER_TABLE_BY_ID = "SELECT * FROM `ordertable` WHERE `ordertableId` = ?";

    public OrderTableDAOImpl() {
        try {
            con = DBUtils.myConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int addOrderTable(orderTable OT) {
        try {
            pstmt = con.prepareStatement(ADD_ORDER_TABLE);
            pstmt.setInt(1, OT.getRestaurantId());
            pstmt.setInt(2, OT.getUserId());
            pstmt.setString(3, OT.getPaymentMode());
            pstmt.setFloat(4, OT.getTotalAmount());
            pstmt.setString(5, OT.getStatus());
            status = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    // New method to get the maximum ordertableId
    public int getMaxOrderTableId() {
        int maxOrderId = -1;  // Initialize with a default value in case no records exist
        try {
            pstmt = con.prepareStatement(GET_MAX_ORDERID);
            resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                maxOrderId = resultSet.getInt("max_order_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return maxOrderId;
    }

    @Override
    public List<orderTable> getAllOrderTable() {
        List<orderTable> orderTableList = new ArrayList<>();
        try {
            pstmt = con.prepareStatement(GET_ALL_ORDER_TABLE);
            resultSet = pstmt.executeQuery();
            orderTableList = extractOrderTableFromResultSet(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderTableList;
    }

    @Override
    public orderTable getOrderTableById(int ordertableId) {
        List<orderTable> orderTableList = new ArrayList<>();
        try {
            pstmt = con.prepareStatement(GET_ORDER_TABLE_BY_ID);
            pstmt.setInt(1, ordertableId);
            resultSet = pstmt.executeQuery();
            orderTableList = extractOrderTableFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderTableList.isEmpty() ? null : orderTableList.get(0);
    }

    List<orderTable> extractOrderTableFromResultSet(ResultSet resultSet) {
        List<orderTable> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                list.add(new orderTable(
                    resultSet.getInt("ordertableId"),
                    resultSet.getInt("restaurantId"),
                    resultSet.getInt("userId"),
                    resultSet.getString("paymentMode"),
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

}
