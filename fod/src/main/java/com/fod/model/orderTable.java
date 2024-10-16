package com.fod.model;

import java.util.Date;

public class orderTable 
{
	private int orderId;
	private int restaurantId;
	private int userId;
	private String paymentMode;
	private Date orderDate;
	private float totalAmount;
	private String Status;
	public orderTable() {
		super();
	}
	public orderTable(int orderId, int restaurantId, int userId, String paymentMode, Date orderDate, float totalAmount,
			String status) {
		super();
		this.orderId = orderId;
		this.restaurantId = restaurantId;
		this.userId = userId;
		this.paymentMode = paymentMode;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.Status = status;
	}
	public orderTable(int restaurantId, int userId, String paymentMode,  float totalAmount,
			String status) {
		super();
		this.restaurantId = restaurantId;
		this.userId = userId;
		this.paymentMode = paymentMode;		
		this.totalAmount = totalAmount;
		this.Status = status;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
		
	
}
