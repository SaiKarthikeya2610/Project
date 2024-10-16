package com.fod.DAO;

import java.util.List;

import com.fod.model.Restaurant;

public interface RestaurantDAO 
{
	public int addRestaurant(Restaurant r);
	public List<Restaurant> getAllRestaurant();
	public Restaurant getRestaurantById(int restaurantId);
	public int updateRestaurant(Restaurant r);
	public int deleteRestaurantById(int restaurantId);
}
