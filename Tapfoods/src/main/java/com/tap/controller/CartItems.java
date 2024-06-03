package com.tap.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.Dao.OrderDao;
import com.tap.model.OrderItems;

public class CartItems extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String menuName =req.getParameter("menuName");
		String IteamPrice =req.getParameter("IteamPrice");
		String menuIdString =req.getParameter("menuId");
		String resIdString =req.getParameter("menuRes");
		
		int menuId =Integer.parseInt(menuIdString);
		int restaurantId =Integer.parseInt(resIdString);
		
		//get the cart and its associated restaurantId from the session
		
		HttpSession session =req.getSession();
		List<OrderItems>cart =(List<OrderItems>)session.getAttribute("cart");
		Integer cartrestaurantId =(Integer)session.getAttribute("cartRestaurantId");
		
		
		//if the cart is empty or the current restaurent Id matches the restaurant Id of the iteams in the cart
		if (cart ==null || cart.isEmpty()|| cartrestaurantId == null || cartrestaurantId == restaurantId)
       {
			//Initialize cart if it doesnt exest
			if(cart == null)
			{
				cart =new ArrayList<>();
			}
			//check if the menu items is alredy in the cart 
			boolean itemExists =false;
			for (OrderItems item : cart)
			{				
				
				if(item.getMenuId() == menuId);
				{
					// if the menu items is alredy in the cart increse its quanty
					item.setQuantity(item.getQuantity()+1);
					itemExists =true;
					break;
				}
			}
			// if the menu iteams is not in the cart, add it with quantity 1
	          if(itemExists)
	          {
	        	  //assmuing price is float
	        	  float price=Float.parseFloat(IteamPrice);
	        	  OrderItems newItem =new OrderItems(menuId,menuName,1,price,restaurantId);
	        	  cart.add(newItem);
	          }
	          //update the session attribute with the modified cart and restaurnt Id
	          session.setAttribute("cart", cart);
	          session.setAttribute("cartRestaurantId", restaurantId);
	          resp.sendRedirect("cartiteams.jsp");
      }
		else
		{
			//if restaurantid changes it comes to same cart items not display
			session.setAttribute("cart", cart);
			session.setAttribute("cartRestaurantId", restaurantId);
	        resp.sendRedirect("cartiteams.jsp");
		}
	}

}
