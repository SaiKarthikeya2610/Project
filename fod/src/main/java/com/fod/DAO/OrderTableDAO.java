package com.fod.DAO;

import java.util.List;

import com.fod.model.orderTable;

public interface OrderTableDAO 
{
	public int addOrderTable(orderTable OT);
	public List<orderTable> getAllOrderTable();
	public orderTable getOrderTableById(int ordertableId);
	public int getMaxOrderTableId();
}

