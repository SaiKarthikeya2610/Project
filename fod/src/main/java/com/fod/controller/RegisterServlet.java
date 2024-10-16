package com.fod.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fod.DAO.UserDAO;
import com.fod.DAOImpl.UserDAOImpl;
import com.fod.model.User;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String phoneNumber = req.getParameter("phoneNumber");
		String address = req.getParameter("address");
		
		User user = new User( username, email, password, phoneNumber, address);
        UserDAO userDAO = new UserDAOImpl();

        int result = userDAO.addUser(user);

        if (result > 0) {
            resp.sendRedirect("login.jsp");
        } else {
            resp.sendRedirect("register.jsp?error=true");
        }
		
	}
}
