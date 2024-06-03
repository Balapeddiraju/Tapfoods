package com.tap.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.Dao.OrderDao;
import com.tap.model.Order;
import com.tap.model.Users;

public class OrderDaoImpl implements OrderDao{
	

	
	final static String Insert_query="insert into `order` "
			+"(`orderId`,`restaurantId`,`userId`,`totalAmount`,`modeofPayment`,`status`)"
			+"values(?,?,?,?,?,?)";
	final static String Select_quary="select * from `order` WHERE `orderId`=?";
	final static String Update_query="Update order SET `restaurantId`=?,`userId`=?,`totalAmount`=?,`modeofPayment`=?,`status`=? WHERE `orderId`=?";
	final static String Delete_quary="delete from `order` WHERE `orderId`=?";
	final static String Select_All_quary="Select * from `order`";
	
	private Connection connection;
	public OrderDaoImpl()
	{
		String url="jdbc:mysql://localhost:3306/tabfoods";
		String username="root";
		String password="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username,password);
		
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}


	@Override
	public void addorder(Order order) {
		PreparedStatement statement;
		try {
			statement=connection.prepareStatement(Insert_query);
			statement.setInt(1, order.getOrderId());
			statement.setInt(2, order.getRestaurantId());
			statement.setInt(3, order.getUserId());
			statement.setInt(4, order.getTotalAmount());
			statement.setString(5, order.getModeofPayment());
			statement.setString(6, order.getStatus());
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Order getorder(int orderId) {
    PreparedStatement statement;
		
		ResultSet res=null;
		Order order=null;
		
		try {
			statement =connection.prepareStatement(Select_quary);
			
			statement.setInt(1,orderId);
			
			statement.executeQuery();
			
			if(res.next())
			{
				
				int restaurantId=res.getInt("restaurantId");
				int userId=res.getInt("userId");
				int totalAmount=res.getInt("totalAmount");
				String modeofPayment=res.getString("modeofPayment");
				String status=res.getString("status");
				
				
				order = new Order(orderId,restaurantId,userId,totalAmount,modeofPayment,status);
				
			}
		

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return  order;
	}

	@Override
	public void updateorder(Order order) {
		PreparedStatement statement;
		try {
			statement=connection.prepareStatement(Update_query);
	          
	            statement.setInt(1, order.getOrderId());
				statement.setInt(2, order.getRestaurantId());
				statement.setInt(3, order.getUserId());
				statement.setInt(4, order.getTotalAmount());
				statement.setString(5, order.getModeofPayment());
				statement.setString(6, order.getStatus());
	          
	          statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteorder(int orderId) {
		PreparedStatement statement;
		
		 try {
			statement=connection.prepareStatement(Delete_quary);
			
			statement.setInt(1, orderId);
			 statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Order> getAllorder() {
		Statement statement=null;
		ResultSet res=null;
		Order order=null;
		
		ArrayList<Order> orderList=new ArrayList<Order>();

		try {
			statement= connection.createStatement();
			res=statement.executeQuery(Select_All_quary);
			while(res.next())
			{
				int orderId =res.getInt("orderId");
				int restaurantId=res.getInt("restaurantId");
				int userId=res.getInt("userId");
				int totalAmount=res.getInt("totalAmount");
				String modeofPayment=res.getString("modeofPayment");
				String status=res.getString("status");
				
				
				order= new Order(orderId, restaurantId, userId, totalAmount, modeofPayment, status);
				
				orderList.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return orderList;
	}
}
	


