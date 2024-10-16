package com.fod.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fod.DAO.menuDAO;
import com.fod.DAOImpl.menuDAOImpl;
import com.fod.model.Menu;
import com.fod.model.cart;
import com.fod.model.cartItem;
@WebServlet("/cartServelet")
public class cartServelet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		cart cart = (cart) session.getAttribute("cart");
		if(cart==null)
		{
			cart =new cart();
			session.setAttribute("cart", cart);
						
		}
		String action=req.getParameter("action");
		if("add".equals(action))
		{
			addItemTOCart(req,cart);
		}
		else if ("update".equals(action)) {
			updateToCartItem(req,cart);
			
		}
		else if("erase".equals(action)){
			earseItemFromCart(req,cart);
		}
		session.setAttribute("cart", cart);
		resp.sendRedirect("cart.jsp");
		
	}
	
	private void addItemTOCart(HttpServletRequest req, cart cart) {
		// TODO Auto-generated method stub
		int  itemId = Integer.parseInt(req.getParameter("itemId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		
		menuDAO menuDAO= new menuDAOImpl();
		Menu menuItemId = menuDAO.getMenuById(itemId);
//		HttpSession session = req.getSession();
//		session.setAttribute("resturantId", menuItemId.getRestaurantId());
		if(menuItemId !=null) {
			cartItem item = new cartItem(
					menuItemId.getMenuId(),
					menuItemId.getRestaurantId(),
					menuItemId.getMenuName(),
					quantity,
					menuItemId.getPrice(),
					quantity* menuItemId.getPrice(),
					menuItemId.getImgpath(),
					
					menuItemId.isAvailable());
			cart.addItems(item);
			
		}
		
		
		
	}

	private void updateToCartItem(HttpServletRequest req, cart cart) {
		// TODO Auto-generated method stub
		
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		cart.updateItem(itemId, quantity);
		
	}

	private void earseItemFromCart(HttpServletRequest req, cart cart) {
		// TODO Auto-generated method stub
		int itemId= Integer.parseInt(req.getParameter("itemId"));
		cart.removeItem(itemId);
	}
}
