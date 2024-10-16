package com.fod.DAO;

import java.util.List;

import com.fod.model.orderItemTable;

public interface OrderItemTableDAO 
{
	public int addOrderItemTable(orderItemTable o);
	public List<orderItemTable> getAllOrderItemTable();
	public orderItemTable getOrderItemTableById(int orderitemtableId);
	public int getMaxOrderItemTableId();
	public List<orderItemTable> getAllOrderItemsByOrderId(int orderId);
}
