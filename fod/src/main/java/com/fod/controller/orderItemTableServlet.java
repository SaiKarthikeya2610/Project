package com.fod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fod.DAO.OrderItemTableDAO;
import com.fod.DAO.OrderTableDAO;
import com.fod.DAOImpl.OrderItemTableDAOImpl;
import com.fod.model.orderItemTable;
import com.fod.model.orderTable;

/**
 * Servlet implementation class orderItemTableServlet
 */
@WebServlet("/orderItemTableServlet")
public class orderItemTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer orderId = Integer.parseInt(  req.getParameter("orderId"));
		OrderItemTableDAO orderTableDAOImpl = new OrderItemTableDAOImpl();
		List<orderItemTable> allOrderItemsByOrderId = orderTableDAOImpl.getAllOrderItemsByOrderId(orderId);
		HttpSession session = req.getSession();
		session.setAttribute("allOrderItemsByOrderId", allOrderItemsByOrderId);
		resp.sendRedirect("orderitemtable.jsp");
	}

}
