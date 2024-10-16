package com.fod.model;

public class Restaurant 
{
	private int restaurantId;
	private String restautantName;
	private String foodType;
	private String address;
	private float ratings;
	private int deliverytime;
	private boolean isActive;
	private int adminUserId;
	private String imgpath;
	public Restaurant() {
		super();
	}
	public Restaurant(int restaurantId, String restautantName, String foodType, String address, float ratings,
			int deliverytime, boolean isActive, int adminUserId, String imgpath) {
		super();
		this.restaurantId = restaurantId;
		this.restautantName = restautantName;
		this.foodType = foodType;
		this.address = address;
		this.ratings = ratings;
		this.deliverytime = deliverytime;
		this.isActive = isActive;
		this.adminUserId = adminUserId;
		this.imgpath = imgpath;
	}
	public Restaurant(String restautantName, String foodType, String address, float ratings, int deliverytime,
			boolean isActive, int adminUserId, String imgpath) {
		super();
		this.restautantName = restautantName;
		this.foodType = foodType;
		this.address = address;
		this.ratings = ratings;
		this.deliverytime = deliverytime;
		this.isActive = isActive;
		this.adminUserId = adminUserId;
		this.imgpath = imgpath;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestautantName() {
		return restautantName;
	}
	public void setRestautantName(String restautantName) {
		this.restautantName = restautantName;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getRatings() {
		return ratings;
	}
	public void setRatings(float ratings) {
		this.ratings = ratings;
	}
	public int getDeliverytime() {
		return deliverytime;
	}
	public void setDeliverytime(int deliverytime) {
		this.deliverytime = deliverytime;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getAdminUserId() {
		return adminUserId;
	}
	public void setAdminUserId(int adminUserId) {
		this.adminUserId = adminUserId;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restautantName=" + restautantName + ", foodType="
				+ foodType + ", address=" + address + ", ratings=" + ratings + ", deliverytime=" + deliverytime
				+ ", isActive=" + isActive + ", adminUserId=" + adminUserId + ", imgpath=" + imgpath + "]";
	}


}


