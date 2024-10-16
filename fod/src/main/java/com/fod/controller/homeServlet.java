package com.fod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fod.DAO.RestaurantDAO;
import com.fod.DAOImpl.RestaurantDAOImpl;
import com.fod.model.Restaurant;
@WebServlet("/homeServlet")
public class homeServlet  extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		RestaurantDAO restaurantDAO = new RestaurantDAOImpl();
        List<Restaurant> restaurantList = restaurantDAO.getAllRestaurant();
        HttpSession session = req.getSession();
        session.setAttribute("restaurantList", restaurantList);
        resp.sendRedirect("homepage.jsp");
	}
}
