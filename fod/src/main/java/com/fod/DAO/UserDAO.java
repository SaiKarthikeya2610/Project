package com.fod.DAO;

import java.util.List;

import com.fod.model.User;

public interface UserDAO 
{
	public int addUser(User u);
	public List<User> getAllUser();
	public User getUser(String email);
	public int updateUser(User u);
	public int deleteUser(String email);
	public int  updatePassword(String email,String Password);
}

