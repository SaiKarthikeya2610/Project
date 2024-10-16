package com.fod.DAO;

import java.util.List;

import com.fod.model.orderHistory;

public interface OrderHistoryDAO {
    public int addOrderHistory(orderHistory OH);
    public List<orderHistory> getAllOrderHistory();
    public orderHistory getOrderHistoryById(int orderHistoryId);
    public List<orderHistory> getAllOrderHistoryonUserID(int userid);
}
