package com.fod.model;

import java.sql.Timestamp;

public class orderHistory {
    // Fields corresponding to the orderhistory table columns
    private int orderhistoryId;  // Primary key, auto-incremented
    private int orderId;         // Foreign key, links to the order table
    private int userId;          // Foreign key, links to the user table
    private Timestamp orderDate; // Date and time of the order
    private float totalAmount;   // Total amount of the order
    private String status;       // Status of the order (e.g., Completed, Pending)

    // Default constructor
    public orderHistory() {}

    // Parameterized constructor
    public orderHistory(int orderhistoryId, int orderId, int userId, Timestamp orderDate, float totalAmount, String status) {
        this.orderhistoryId = orderhistoryId;
        this.orderId = orderId;
        this.userId = userId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
    }
    

    public orderHistory(int orderId, int userId, float totalAmount, String status) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.status = status;
	}

	// Getters and Setters for each field
    public int getOrderhistoryId() {
        return orderhistoryId;
    }

    public void setOrderhistoryId(int orderhistoryId) {
        this.orderhistoryId = orderhistoryId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Overriding the toString method for easy output and debugging
    @Override
    public String toString() {
        return "OrderHistory{" +
                "orderhistoryId=" + orderhistoryId +
                ", orderId=" + orderId +
                ", userId=" + userId +
                ", orderDate=" + orderDate +
                ", totalAmount=" + totalAmount +
                ", status='" + status + '\'' +
                '}';
    }
}
