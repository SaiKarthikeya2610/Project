package com.fod.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fod.DAO.OrderItemTableDAO;
import com.fod.DAO.OrderTableDAO;
import com.fod.DAOImpl.OrderHistoryDAOImpl;
import com.fod.DAOImpl.OrderItemTableDAOImpl;
import com.fod.DAOImpl.OrderTableDAOImpl;
import com.fod.model.User;
import com.fod.model.cart;
import com.fod.model.cartItem;
import com.fod.model.orderHistory;
import com.fod.model.orderItemTable;
import com.fod.model.orderTable;

/**
 * Servlet implementation class placeorderServlet
 */
@WebServlet("/placeOrderServlet")
public class placeorderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		
		String Status="Pending";
		String Payment = req.getParameter("Payment");
		Float totalAmount = Float.parseFloat(  req.getParameter("totalAmount"));
		HttpSession session = req.getSession();
		User user	= (User)session.getAttribute("user");
		if(user==null)
		{
			resp.sendRedirect("loginfailure.jsp");
			return;
		}
		cart cart = (cart) session.getAttribute("cart");
		if(cart==null || cart.getItems().isEmpty() )
		{
			resp.sendRedirect("cart.jsp");
			return;			
		}
		int qunatity = cart.getItems().values().iterator().next().getQunatity();
		float price = cart.getItems().values().iterator().next().getPrice();
		int itemid = cart.getItems().values().iterator().next().getItemid();
		int resturantId = cart.getItems().values().iterator().next().getResturantId();
		int userId = user.getuserId();
		
		OrderTableDAO orderTableDAOImpl = new OrderTableDAOImpl();
		orderTable orderTable = new orderTable(resturantId, userId, Payment,totalAmount,Status);
		 orderTableDAOImpl.addOrderTable(orderTable);
		int orderId = orderTableDAOImpl.getMaxOrderTableId();
		
//		System.out.println(orderId);
		OrderItemTableDAO orderItemTableDAOImpl = new OrderItemTableDAOImpl();
		for (cartItem item : cart.getItems().values()) {
			orderItemTable orderItemTable = new orderItemTable(
					orderId, 
					item.getItemid(),
					item.getQunatity(), 
					item.getSubtotal());
			
			orderItemTableDAOImpl.addOrderItemTable(orderItemTable);
		}
		
		
		
		OrderHistoryDAOImpl orderHistoryDAOImpl = new OrderHistoryDAOImpl();
		orderHistory orderHistory = new orderHistory(orderId, userId, totalAmount, Status);
		int orderHistory2 = orderHistoryDAOImpl.addOrderHistory(orderHistory);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("orderConfirmation.jsp");
		dispatcher.forward(req, resp);
			
		if(orderHistory2>0)
		{
			cart.clear();
		}
		
		
	}

}
