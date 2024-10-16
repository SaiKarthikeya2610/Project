package com.fod.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import com.fod.DAO.RestaurantDAO;
import com.fod.ddutils.DBUtils;
import com.fod.model.Restaurant;

public class RestaurantDAOImpl implements RestaurantDAO 
{
	Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	List<Restaurant> restaurantList = new ArrayList<>();
	int status = 0;
	private Restaurant restaurant;

	private static final String ADD_RESTAURANT = "INSERT INTO restaurant(`restaurantName`, `foodType`, `address`, `ratings`, `deliveryTime`, `isActive`, `adminUserId`, `imgPath`) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_RESTAURANT = "SELECT * FROM `restaurant`";
	private static final String GET_RESTAURANT_BY_Id = "SELECT * FROM `restaurant` WHERE `restaurantId` = ?";
	private static final String UPDATE_RESTAURANT = "UPDATE `restaurant` SET `restaurantName` = ?, `foodType` = ?, `address` = ?, `ratings` = ?, `deliveryTime` = ?, `isActive` = ?, `adminUserId` = ?, `imgPath` = ?  where `restaurantId`=?";
	private static final String DELETE_RESTAURANT = "DELETE FROM `restaurant` WHERE `restaurantId` = ?";

	public RestaurantDAOImpl() {
		try {
			con = DBUtils.myConnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int addRestaurant(Restaurant r) {
		try {
			pstmt = con.prepareStatement(ADD_RESTAURANT);

			pstmt.setString(1, r.getRestautantName());
			pstmt.setString(2, r.getFoodType());
			pstmt.setString(3, r.getAddress());
			pstmt.setFloat(4, r.getRatings());
			pstmt.setInt(5, r.getDeliverytime());
			pstmt.setBoolean(6, r.isActive());
			pstmt.setInt(7, r.getAdminUserId());
			pstmt.setString(8, r.getImgpath());
			status = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		try {
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(GET_ALL_RESTAURANT);
			restaurantList = extractRestaurantFromResultSet(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Resturant get");
		return restaurantList;
	}

	@Override
	public Restaurant getRestaurantById(int resturantId) {
		try {
			pstmt = con.prepareStatement(GET_RESTAURANT_BY_Id);
			pstmt.setInt(1, resturantId);
			resultSet = pstmt.executeQuery();
			restaurantList = extractRestaurantFromResultSet(resultSet);
			if (!restaurantList.isEmpty()) {
				restaurant = restaurantList.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return restaurant;
	}

	@Override
	public int updateRestaurant(Restaurant r) {
		try {
			pstmt = con.prepareStatement(UPDATE_RESTAURANT);
			pstmt.setString(2, r.getFoodType());
			pstmt.setString(3, r.getAddress());
			pstmt.setFloat(4, r.getRatings());
			pstmt.setInt(5, r.getDeliverytime());
			pstmt.setBoolean(6, r.isActive());
			pstmt.setInt(7, r.getAdminUserId());
			pstmt.setString(8, r.getImgpath());
			pstmt.setString(1, r.getRestautantName());
			pstmt.setInt(9, r.getRestaurantId());
			status = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteRestaurantById(int restaurantId) {
		try {
			pstmt = con.prepareStatement(DELETE_RESTAURANT);
			pstmt.setInt(1, restaurantId);
			status = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	List<Restaurant> extractRestaurantFromResultSet(ResultSet resultSet) {
		List<Restaurant> list = new ArrayList<>();
		try {
			while (resultSet.next()) {
				list.add(new Restaurant(
						resultSet.getInt("restaurantId"),
						resultSet.getString("restaurantName"),
						resultSet.getString("foodType"),
						resultSet.getString("address"),
						resultSet.getFloat("ratings"),
						resultSet.getInt("deliveryTime"),
						resultSet.getBoolean("isActive"),
						resultSet.getInt("adminUserId"),
						resultSet.getString("imgPath")
						));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}



