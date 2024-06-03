package com.tap.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.DaoImpl.RestaurantDaoImpl;
import com.tap.model.Restaurant;

@WebServlet("/CallingServlet1")
public class RestaurantServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RestaurantDaoImpl r=new RestaurantDaoImpl();
		
		ArrayList<Restaurant> list=new ArrayList<Restaurant>(r.getAllRestaurant());
		
		req.setAttribute("restaurants", list);
		RequestDispatcher rd=req.getRequestDispatcher("Restaurants.jsp");
		rd.forward(req, resp);
	}

}
