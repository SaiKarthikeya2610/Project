package com.fod.model;

public class Menu 
{
	private int menuId;
    private int restaurantId;
    private String menuName;
    private float price;
    private String description;
    private boolean isAvailable;
    private String imgpath;
	public Menu() {
		super();
	}
	public Menu(int menuId, int restaurantId, String menuName, float price, String description, boolean isAvailable,
			String imgpath) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.menuName = menuName;
		this.price = price;
		this.description = description;
		this.isAvailable = isAvailable;
		this.imgpath = imgpath;
	}
	public Menu(int restaurantId, String menuName, float price, String description, boolean isAvailable,
			String imgpath) {
		super();
		this.restaurantId = restaurantId;
		this.menuName = menuName;
		this.price = price;
		this.description = description;
		this.isAvailable = isAvailable;
		this.imgpath = imgpath;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", restaurantId=" + restaurantId + ", menuName=" + menuName + ", price="
				+ price + ", description=" + description + ", isAvailable=" + isAvailable + ", imgpath=" + imgpath
				+ "]";
	}
    

}
