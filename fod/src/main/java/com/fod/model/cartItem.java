package com.fod.model;

public class cartItem
{
	private int itemid;
	private int resturantId;
	private String itemName;
	private int qunatity;
	private float price;
	private float subtotal;
	private String imgpath;
	private boolean isAvaliable;
	
	public boolean isAvaliable() {
		return isAvaliable;
	}
	public void setAvaliable(boolean isAvaliable) {
		this.isAvaliable = isAvaliable;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getResturantId() {
		return resturantId;
	}
	public void setResturantId(int resturantId) {
		this.resturantId = resturantId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQunatity() {
		return qunatity;
	}
	public void setQunatity(int qunatity) {
		this.qunatity = qunatity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	public cartItem() {
		super();
	}
	public cartItem(int itemid, int resturantId, String itemName, int qunatity, float price, float subtotal,String imgpath,boolean isAvaliable) {
		super();
		this.itemid = itemid;
		this.resturantId = resturantId;
		this.itemName = itemName;
		this.qunatity = qunatity;
		this.price = price;
		this.subtotal = subtotal;
		this.imgpath=imgpath;
		this.isAvaliable=isAvaliable;
	}
	@Override
	public String toString() {
		return "cartItem [itemid=" + itemid + ", resturantId=" + resturantId + ", itemName=" + itemName + ", qunatity="
				+ qunatity + ", price=" + price + ", subtotal=" + subtotal + ", imgpath=" + imgpath + ", isAvaliable="
				+ isAvaliable + "]";
	}
	
	
}