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
import com.fod.DAO.menuDAO;
import com.fod.DAOImpl.RestaurantDAOImpl;
import com.fod.DAOImpl.menuDAOImpl;
import com.fod.model.Menu;
import com.fod.model.Restaurant;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/menuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Integer restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
		
		menuDAO MenuDAO = new menuDAOImpl();
		List<Menu > MenuDAO1  = (List<Menu>) MenuDAO.getMenusByRestaurantId(restaurantId);
		HttpSession session = req.getSession();
		System.out.println(session);
		session.setAttribute("MenuDAO1", MenuDAO1);
		RestaurantDAO restaurantDAOImpl = new RestaurantDAOImpl();
		Restaurant restaurantById = restaurantDAOImpl.getRestaurantById(restaurantId);
		session.setAttribute("restaurantById", restaurantById);
		resp.sendRedirect("menu.jsp");
		
		
	}

}
