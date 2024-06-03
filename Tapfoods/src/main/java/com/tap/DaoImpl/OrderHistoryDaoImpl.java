package com.tap.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.Dao.OrderHistoryDao;
import com.tap.model.OrderHistory;
import com.tap.model.Users;

public class OrderHistoryDaoImpl implements OrderHistoryDao{
	
	final static String Insert_query="insert into `orderhistory` "
			+"(`orderHistoryId`,`userId`,`menuId`)"
			+"values(?,?,?)";
	final static String Select_quary="select * from `orderhistory` WHERE `orderHistoryId`=?";
	final static String Update_query="Update orderhistory SET `userId`=?,`menuId`=? WHERE `orderHistoryId`=?";
	final static String Delete_quary="delete from `orderhistory` WHERE `orderHistoryId`=?";
	final static String Select_All_quary="Select * from `orderhistory`";
	
	private Connection connection;
	public OrderHistoryDaoImpl()
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
	public void addOrderHistory(OrderHistory orderHistory) {
		
		PreparedStatement statement;
		try {
			statement=connection.prepareStatement(Insert_query);
			statement.setInt(1, orderHistory.getOrderHistoryId());
			statement.setInt(2, orderHistory.getUserId());
			statement.setInt(3, orderHistory.getMenuId());
			
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public OrderHistory getOrderHistory(int orderHistoryId) {
        PreparedStatement statement;
		
		ResultSet res=null;
		OrderHistory orderHistory=null;
		
		try {
			statement =connection.prepareStatement(Select_quary);
			
			statement.setInt(1,orderHistoryId);
			
			statement.executeQuery();
			
			if(res.next())
			{
				
				int userId=res.getInt("userId");
				int menuId=res.getInt("menuId");
				
				
				orderHistory = new OrderHistory(orderHistoryId,userId,menuId);
				
			}
		

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return  orderHistory;
	}

	

	@Override
	public void updateOrderHistory(OrderHistory orderHistory) {
		PreparedStatement statement;
		try {
			statement=connection.prepareStatement(Update_query);
			 
	          statement.setInt(1,orderHistory.getOrderHistoryId());
	          statement.setInt(2,orderHistory.getUserId());
	          statement.setInt(3,orderHistory.getMenuId());
	          
	          
	          statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrderHistory(int orderHistoryId) {
		PreparedStatement statement;
		
		 try {
			statement=connection.prepareStatement(Delete_quary);
			
			statement.setInt(1, orderHistoryId);
			 statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<OrderHistory> getAllOrderHistory() {
		Statement statement=null;
		ResultSet res=null;
		OrderHistory orderHistory=null;
		
		ArrayList<OrderHistory> OrderHistoryList=new ArrayList<OrderHistory>();
		
		try {
			statement= connection.createStatement();
			res=statement.executeQuery(Select_All_quary);
			while(res.next())
			{
				int orderHistoryId =res.getInt("orderHistoryId");
				int userId=res.getInt("userId");
				int menuId=res.getInt("menuId");
				
				orderHistory= new OrderHistory(orderHistoryId, userId, menuId);
				
				OrderHistoryList.add(orderHistory);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return OrderHistoryList;
	}

}
