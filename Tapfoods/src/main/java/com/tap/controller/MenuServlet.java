package com.tap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.DaoImpl.MenuDaoImpl;
import com.tap.DaoImpl.RestaurantDaoImpl;
import com.tap.model.Menu;
import com.tap.model.Restaurant;

@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MenuDaoImpl r=new MenuDaoImpl();
		
		int id=Integer.parseInt((req.getParameter("restaurantId")));
		List<Menu> list = r.getMunu(id);
		req.setAttribute("menu", list);
		RequestDispatcher rd=req.getRequestDispatcher("Menu.jsp");
		rd.forward(req, resp);
		
	}

}
