package com.tap.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.DaoImpl.UserDeoImpl;
import com.tap.model.Users;

@WebServlet("/Signup")
public class SignupServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name =req.getParameter("name");
		String email =req.getParameter("email");
		int phoneNo =Integer.parseInt(req.getParameter("phoneNo"));
		String username =req.getParameter("username");
		String password =req.getParameter("password");
		UserDeoImpl udi =new UserDeoImpl();
		Users u =new Users(16,name,email,phoneNo,null,username,password,null);
		udi.adduser(u);
		RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
		rd.forward(req,resp);
	}
}
