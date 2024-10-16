package com.fod.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import com.fod.DAO.OrderItemTableDAO;
import com.fod.ddutils.DBUtils;
import com.fod.model.orderItemTable;

public class OrderItemTableDAOImpl implements OrderItemTableDAO {
    Connection con;
    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet resultSet;
    List<orderItemTable> orderItemTableList = new ArrayList<>();
    int status = 0;
    private orderItemTable orderItemTable;
    
    private static final String GET_ALL_ORDERS_BY_ORDERID="SELECT * FROM `orderitemtable` where `orderId`=?";
    private static final String ADD_ORDER_ITEM_TABLE = "INSERT INTO orderitemtable(`orderId`, `menuId`, `quantity`, `subtotal`) VALUES(?, ?, ?, ?)";
    private static final String GET_ALL_ORDER_ITEM_TABLE = "SELECT * FROM `orderitemtable`";
    private static final String GET_ORDER_ITEM_TABLE_BY_ID = "SELECT * FROM `orderitemtable` WHERE `orderitemtableId` = ?";
    private static final String GET_MAX_ORDER_ITEM_TABLE_BY_ID = "SELECT MAX(`orderitemtableId`) from `orderitemtable`";

    public OrderItemTableDAOImpl() {
        try {
            con = DBUtils.myConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int addOrderItemTable(orderItemTable o) {
        try {
            pstmt = con.prepareStatement(ADD_ORDER_ITEM_TABLE);
            pstmt.setInt(1, o.getOrderId());
            pstmt.setInt(2, o.getMenuId());
            pstmt.setInt(3, o.getQuanitiy());
            pstmt.setFloat(4, o.getSubtotal());
            status = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public List<orderItemTable> getAllOrderItemTable() {
        try {
            stmt = con.createStatement();
            resultSet = stmt.executeQuery(GET_ALL_ORDER_ITEM_TABLE);
            orderItemTableList = extractOrderItemTableFromResultSet(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderItemTableList;
    }
    

    @Override
    public orderItemTable getOrderItemTableById(int orderitemtableId) {
        try {
            pstmt = con.prepareStatement(GET_ORDER_ITEM_TABLE_BY_ID);
            pstmt.setInt(1, orderitemtableId);
            resultSet = pstmt.executeQuery();
            orderItemTableList = extractOrderItemTableFromResultSet(resultSet);
            if (!orderItemTableList.isEmpty()) {
                orderItemTable = orderItemTableList.get(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItemTable;
    }
    @Override
    public int getMaxOrderItemTableId() {
        int maxOrderItemTableId = 0; // Default value in case there are no records
        try {
            stmt = con.createStatement();
            resultSet = stmt.executeQuery(GET_MAX_ORDER_ITEM_TABLE_BY_ID);
            
            if (resultSet.next()) {
                maxOrderItemTableId = resultSet.getInt(1); // Get the first column result
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return maxOrderItemTableId;
    }
    
    
    
    @Override
    public List<orderItemTable> getAllOrderItemsByOrderId(int orderId) {
    	try {
    		pstmt = con.prepareStatement(GET_ALL_ORDERS_BY_ORDERID);
    		pstmt.setInt(1, orderId);
    		resultSet = pstmt.executeQuery();
    		orderItemTableList =extractOrderItemTableFromResultSet(resultSet);
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	return orderItemTableList;
    }

    List<orderItemTable> extractOrderItemTableFromResultSet(ResultSet resultSet) {
        List<orderItemTable> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                list.add(new orderItemTable(
                        resultSet.getInt("orderitemtableId"),
                        resultSet.getInt("orderId"),
                        resultSet.getInt("menuId"),
                        resultSet.getInt("quantity"),
                        resultSet.getFloat("subtotal")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
