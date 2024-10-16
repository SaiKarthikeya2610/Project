package com.fod.model;

public class orderItemTable
{
	private int orderItemId;
	private int orderId;
	private int menuId;
	private int quanitiy;
	private float subtotal;
	public orderItemTable() {
		super();
	}
	public orderItemTable(int orderItemId, int orderId, int menuId, int quanitiy, float subtotal) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.menuId = menuId;
		this.quanitiy = quanitiy;
		this.subtotal = subtotal;
	}
	public orderItemTable(int orderId, int menuId, int quanitiy, float subtotal) {
		super();
		this.orderId = orderId;
		this.menuId = menuId;
		this.quanitiy = quanitiy;
		this.subtotal = subtotal;
	}
	
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getQuanitiy() {
		return quanitiy;
	}
	public void setQuanitiy(int quanitiy) {
		this.quanitiy = quanitiy;
	}
	public float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
}
