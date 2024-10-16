package com.fod.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import com.fod.DAO.menuDAO;
import com.fod.ddutils.DBUtils;
import com.fod.model.Menu;

public class menuDAOImpl implements menuDAO {
	Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	List<Menu> menuList = new ArrayList<>();
	int status = 0;
	private Menu menu;

	private static final String ADD_MENU = "INSERT INTO menu(restaurantId, menuName, price, description, isAvailable, imgPath) VALUES(?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_MENUS = "SELECT * FROM menu";
	private static final String GET_MENU_BY_ID = "SELECT * FROM menu WHERE menuId = ?";
	private static final String UPDATE_MENU = "UPDATE menu SET restaurantId = ?, menuName = ?, price = ?, description = ?, isAvailable = ?, imgPath = ? WHERE menuId = ?";
	private static final String DELETE_MENU = "DELETE FROM menu WHERE menuId = ?";
	private static final String GET_MENUS_BY_RESTAURANT_ID = "SELECT * FROM menu WHERE restaurantId = ?";

	public menuDAOImpl() {
		try {
			con = DBUtils.myConnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int addMenu(Menu m) {
		try {
			pstmt = con.prepareStatement(ADD_MENU);
			pstmt.setInt(1, menu.getRestaurantId());
			pstmt.setString(2, menu.getMenuName());
			pstmt.setFloat(3, menu.getPrice());
			pstmt.setString(4, menu.getDescription());
			pstmt.setBoolean(5, menu.isAvailable());
			pstmt.setString(6, menu.getImgpath());
			status = pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Menu> getAllMenu() 
	{
		try {
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(GET_ALL_MENUS);
			menuList = extractMenuFromResultSet(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menuList;
	}

	@Override
	public Menu getMenuById(int menuId) {
		try {
			pstmt = con.prepareStatement(GET_MENU_BY_ID);
			pstmt.setInt(1, menuId);
			resultSet = pstmt.executeQuery();
			menuList = extractMenuFromResultSet(resultSet);
			if (!menuList.isEmpty()) {
				menu = menuList.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menu;
	}

	@Override
	public int updateMenu(Menu menu) {
		try {
			pstmt = con.prepareStatement(UPDATE_MENU);
			pstmt.setInt(1, menu.getRestaurantId());
			pstmt.setString(2, menu.getMenuName());
			pstmt.setFloat(3, menu.getPrice());
			pstmt.setString(4, menu.getDescription());
			pstmt.setBoolean(5, menu.isAvailable());
			pstmt.setString(6, menu.getImgpath());
			pstmt.setInt(7, menu.getMenuId());
			status = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteMenuById(int menuId) {
		try {
			pstmt = con.prepareStatement(DELETE_MENU);
			pstmt.setInt(1, menuId);
			status = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Menu> getMenusByRestaurantId(int restaurantId) {
		try {
			pstmt = con.prepareStatement(GET_MENUS_BY_RESTAURANT_ID);
			pstmt.setInt(1, restaurantId);
			resultSet = pstmt.executeQuery();
			menuList = extractMenuFromResultSet(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menuList;
	}

	List<Menu> extractMenuFromResultSet(ResultSet resultSet) {
		List<Menu> list = new ArrayList<>();
		try {
			while (resultSet.next()) {
				list.add(new Menu(
						resultSet.getInt("menuId"),
						resultSet.getInt("restaurantId"),
						resultSet.getString("menuName"),
						resultSet.getFloat("price"),
						resultSet.getString("description"),
						resultSet.getBoolean("isAvailable"),
						resultSet.getString("imgPath")
						));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


}


