package com.fod.DAO;

import java.util.List;

import com.fod.model.Menu;
import com.fod.model.Restaurant;

public interface menuDAO 
{
	public int addMenu(Menu M);
	public List<Menu> getAllMenu();
	public Menu getMenuById(int menuId);
	public int updateMenu(Menu M);
	public int deleteMenuById(int menuId);
	public List<Menu> getMenusByRestaurantId(int restaurantId);
}

