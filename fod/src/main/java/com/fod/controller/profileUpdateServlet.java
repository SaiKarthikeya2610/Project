package com.fod.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fod.DAO.UserDAO;
import com.fod.DAOImpl.UserDAOImpl;
import com.fod.model.User;

/**
 * Servlet implementation class profileUpdateServlet
 */
@WebServlet("/profileUpdateServlet")
public class profileUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int updateUser;
       
    @Override
    	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	PrintWriter writer = resp.getWriter();
    	
    	String username = req.getParameter("username");
    		String password = req.getParameter("password");
    		String phoneNumber = req.getParameter("phoneNumber");
    		String address = req.getParameter("address");
//    		String userId = req.getParameter("userId");
    		HttpSession session = req.getSession();
    		User user = (User) session.getAttribute("user");
    		if(user !=null) {
    			int userid = user.getuserId();
    			UserDAO userDAOImpl = new UserDAOImpl();
    			User user1 = new User(userid, username, password, phoneNumber, address);
    			 updateUser = userDAOImpl.updateUser(user1);
    			 if(updateUser>0);
    			 {
    				 resp.sendRedirect("profileupdatedSucess.jsp");
    			 }
    			 
    			 writer.println("user not is not updated in");
    		}
    		else {
    			writer.println("user is not loged in");
    		}
    		
    
    
    }

}
