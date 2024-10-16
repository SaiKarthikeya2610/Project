package com.fod.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fod.DAO.UserDAO;
import com.fod.ddutils.DBUtils;
import com.fod.model.User;

public class UserDAOImpl implements UserDAO
{
	Connection con;
	private PreparedStatement pstmt;
	private Statement cstmt;
	private ResultSet resultSet;
	List<User> userList=new ArrayList<User>();
 	int Status=0;
	private User user;
	
	private static final String  ADD_USER="insert into user(`userName`,`email`,`password`,`phoneNumber`,`address`) values(?,?,?,?,?)";
	private static final String  GET_ALl_USER="select * from `user`";
	private static final String  GET_USER_ON_EMAIL="select * from `user` where `email`=?";
	private static final String  UPDATE_ON_USERID="UPDATE `user` SET `userName` = ?,`password`=?,`phoneNumber`=?,`address`=? WHERE `userId` = ?";
	private static final String  DELETE_ON_EMAIL="Delete from `user`  WHERE `email` = ?";
	private static final String	 UPDATE_PASSWORD_BY_EMAIL="UPDATE `user` set `password`=? where `email`=?";
	
	
	
	public UserDAOImpl() 
	{
		try 
		{
			con = DBUtils.myConnect();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}




	@Override
	public int addUser(User u) 
	{
		try {

			pstmt=con.prepareStatement(ADD_USER);

			pstmt.setString(1, u.getuserName());
			pstmt.setString(2, u.getEmail());
			pstmt.setString(3, u.getPassword());
			pstmt.setString(4, u.getPhoneNumber());
			pstmt.setString(5, u.getAddress());

			Status=pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return Status;
	}
	
	
	
	
	@Override
	public List<User> getAllUser() 
	{
		try
		{
			cstmt=con.createStatement();
			resultSet=cstmt.executeQuery(GET_ALl_USER);
			userList=extractUserFromResultSet(resultSet);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return userList;		
	}
	
	
	
	
	@Override
	public User getUser(String email) 
	{
		try 
		{
			pstmt=con.prepareStatement(GET_USER_ON_EMAIL);
			pstmt.setString(1, email);
			resultSet=pstmt.executeQuery();
			userList=extractUserFromResultSet(resultSet);
			user = userList.get(0);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return user;

	}
	
	
	
	
	@Override
	public int updateUser(User u) 
	{
		try
		{
			pstmt=con.prepareStatement(UPDATE_ON_USERID);
			
			pstmt.setString(1, u.getuserName());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getPhoneNumber());
			pstmt.setString(4, u.getAddress());
			pstmt.setInt(5, u.getuserId());
			
			Status=pstmt.executeUpdate();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return Status;
	}
	
	
	
	@Override
	public int deleteUser(String email)
	{ 
		try
		{
			pstmt =con.prepareStatement(DELETE_ON_EMAIL);
			pstmt.setString(1, email);
			
			Status=pstmt.executeUpdate();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return Status;
	}
	
	
	
	List<User> extractUserFromResultSet(ResultSet resultSet)
	{
		try 
		{
			while(resultSet.next())
			{
				User user=new User();
				userList.add(new User(resultSet.getInt("userId"),
				resultSet.getString("userName"),
				resultSet.getString("email"),
				resultSet.getString("password"),
				resultSet.getString("phoneNumber"),
				resultSet.getString("address")));
				
				
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return userList;
	}




	@Override
	public int updatePassword(String email, String Password) {
		try {
			pstmt =con.prepareStatement(UPDATE_PASSWORD_BY_EMAIL);
			pstmt.setString(1, Password);
			pstmt.setString(2, email);
			int executeUpdate = pstmt.executeUpdate();
			return executeUpdate;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return 0;
	}
}
