package com.fod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fod.DAO.OrderHistoryDAO;
import com.fod.DAOImpl.OrderHistoryDAOImpl;
import com.fod.model.User;
import com.fod.model.orderHistory;

/**
 * Servlet implementation class orderHistoryServlet
 */
@WebServlet("/orderHistoryServlet")
public class orderHistoryServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		int userId = user.getuserId();
		System.out.println(userId);

		OrderHistoryDAO orderHistoryDAOImpl = new OrderHistoryDAOImpl();
		List<orderHistory> allOrderHistoryonUserID = orderHistoryDAOImpl.getAllOrderHistoryonUserID(userId);
		session.setAttribute("allOrderHistoryonUserID", allOrderHistoryonUserID);
		resp.sendRedirect("OrderHistroy.jsp");
		//		System.out.println("order History");
	}
}

