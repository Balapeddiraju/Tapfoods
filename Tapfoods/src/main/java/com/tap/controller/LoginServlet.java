package com.tap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.DaoImpl.MenuDaoImpl;
import com.tap.DaoImpl.RestaurantDaoImpl;
import com.tap.DaoImpl.UserDeoImpl;
import com.tap.model.Restaurant;
import com.tap.model.Users;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet{
	
	public int count=3;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username =req.getParameter("username");
		String password =req.getParameter("password");
		UserDeoImpl udi =new UserDeoImpl();
		Users users= udi.getUserLogin(username);
		PrintWriter out =resp.getWriter();
		
		resp.setContentType("text/html");
		
		if(users!=null)
		{
			String pwd =users.getpassword();
			if(password.equals(pwd))
			{
				req.setAttribute("username",username);
//				out.print("welcome To Tap Foods"+username);
				RestaurantDaoImpl r=new RestaurantDaoImpl();
				List<Restaurant> all=r.getAllRestaurant();
				req.setAttribute("restaurants", all);
				RequestDispatcher rd=req.getRequestDispatcher("Restaurants.jsp");
				rd.forward(req,resp);	
			}
			else if(count>0 && !(password.equals(pwd)) )
			{
				req.setAttribute("count",count);
//				out.print("enter valid password"+count+"attempts left");
				RequestDispatcher rd =req.getRequestDispatcher("Login.jsp");
				rd.include(req,resp);
				count--;
			}
			else
			{
			    req.setAttribute("count",count);
			   // out.print("contect admin");
				RequestDispatcher rd =req.getRequestDispatcher("Login.jsp");
				rd.include(req,resp);
			}
		}
		
	}
}
		
	
	


