package com.fod.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fod.DAO.UserDAO;
import com.fod.DAOImpl.UserDAOImpl;

/**
 * Servlet implementation class forgetPasswordServlet
 */
@WebServlet("/forgetPasswordServlet")
public class forgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String email = req.getParameter("email");
    	String password = req.getParameter("password");
    	UserDAO userDAOImpl = new UserDAOImpl();
    	int updatePassword = userDAOImpl.updatePassword(email, password);
    	if(updatePassword!=0)
    	{
    		resp.sendRedirect("passwordUpdatedSucessfully.jsp");
    	}
    }

}
