package com.fod.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fod.DAO.UserDAO;
import com.fod.DAOImpl.UserDAOImpl;
import com.fod.model.User;
@WebServlet("/loginServlet")
public class loginServlet extends  HttpServlet 
{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{	
		UserDAO userdao=new UserDAOImpl();
	
		String email= req.getParameter("email");
		String password= req.getParameter("password");
		
		
		User user=userdao.getUser(email);
	
		if(user!=null &&password.equals(user.getPassword())) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			resp.sendRedirect("homeServlet");
		}
		else {
			resp.sendRedirect("faliure.jsp");
		}
	}
}
