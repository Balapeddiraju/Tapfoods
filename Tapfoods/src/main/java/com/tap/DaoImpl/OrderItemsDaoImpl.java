package com.tap.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.Dao.OrderItemsDao;
import com.tap.model.OrderItems;
import com.tap.model.Users;

public class OrderItemsDaoImpl implements OrderItemsDao{

	final static String Insert_query="insert into `orderitems` "
			+"(`orderItemId`,`userId`,`menuId`,`name`,`quantity`,`ratings`,`price`)"
			+"values(?,?,?,?,?,?,?)";
	final static String Select_quary="select * from `orderitems` WHERE `orderItemId`=?";
	final static String Update_query="Update orderitems SET `userId`=?,`menuId`=?,`name`=?,`quantity`=?,`ratings`=?,`price`=?` WHERE `orderItemId`=?";
	final static String Delete_quary="delete from `orderitems` WHERE `orderItemId`=?";
	final static String Select_All_quary="Select * from `orderitems`";
	
	private Connection connection;
	public OrderItemsDaoImpl()
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
	public void addorderItems(OrderItems orderItems) {
		PreparedStatement statement;
		try {
			statement=connection.prepareStatement(Insert_query);
			statement.setInt(1, orderItems.getOrderItemId());
			statement.setInt(2, orderItems.getUserId());
			statement.setInt(3, orderItems.getMenuId());
			statement.setString(4, orderItems.getName());
			statement.setInt(5, orderItems.getQuantity());
			statement.setFloat(6, orderItems.getRatings());
			statement.setFloat(7, orderItems.getPrice());
			
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public OrderItems getorderItems(int orderItemId) {
        PreparedStatement statement;
		
		ResultSet res=null;
		OrderItems orderItems=null;
		
		try {
			statement =connection.prepareStatement(Select_quary);
			
			statement.setInt(1,orderItemId);
			
			statement.executeQuery();
			
			if(res.next())
			{
				
				int userId=res.getInt("userId");
				int menuId=res.getInt("menuId");
				String name=res.getString("name");
				int quantity=res.getInt("quantity");
				float ratings=res.getFloat("ratings");
				float price=res.getFloat("price");
				
				
				orderItems = new OrderItems(orderItemId,userId,menuId,name,quantity,ratings,price);
				
			}
		

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return  orderItems;
		
	}

	@Override
	public void updateorderItems(OrderItems orderItems) {
		PreparedStatement statement;
		try {
			statement=connection.prepareStatement(Update_query);
			 
	          statement.setInt(1,orderItems.getOrderItemId());
	          statement.setInt(2,orderItems.getUserId());
	          statement.setInt(3,orderItems.getMenuId());
	          statement.setString(4,orderItems.getName());
	          statement.setInt(5,orderItems.getQuantity());
	          statement.setFloat(6,orderItems.getRatings());
	          statement.setFloat(7,orderItems.getPrice());
	          
	          statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
	}

	@Override
	public void deleteorderItems(int orderItemId) {
		PreparedStatement statement;
		
		 try {
			statement=connection.prepareStatement(Delete_quary);
			
			statement.setInt(1, orderItemId);
			 statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<OrderItems> getAllorderItems() {

		Statement statement=null;
		ResultSet res=null;
		OrderItems orderItems=null;
		
		ArrayList<OrderItems> orderItemsList=new ArrayList<OrderItems>();
		
		try {
			statement= connection.createStatement();
			res=statement.executeQuery(Select_All_quary);
			while(res.next())
			{
				int orderItemId =res.getInt("orderItemId");
				int userId=res.getInt("userId");
				int menuId=res.getInt("menuId");
				String name=res.getString("name");
				int quantity=res.getInt("quantity");
				Float ratings=res.getFloat("ratings");
				Float price=res.getFloat("price");
				
				
				orderItems= new OrderItems(orderItemId, userId, menuId, name, quantity, ratings, price);
				
				orderItemsList.add(orderItems);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
		return orderItemsList;
	}

}
