package com.tap.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;
import com.tap.Dao.RestaurantDao;
import com.tap.model.Restaurant;

public class RestaurantDaoImpl implements RestaurantDao {
	final static String INSERT_QUEARY="Insert into restaurant(`restaurantId`,`name`,`imagePath`,`ratings`,`eta`,`cuisineType`,`Address`,`isActive`,`restaurantOwnerId`)"
			+ " values(?,?,?,?,?,?,?,?,?)";
	final static String SELECT_QUARY="SELECT * from `restaurant` WHERE `restaurantId`=?";
	
	final static String DELETE_QUARY="DELETE from `restaurant` WHERE `restaurantId`=?";
	final static String SELECT_ALL_QUERY="SELECT * from `restaurant`";
	
	
	private Connection connection;
	
	public RestaurantDaoImpl()
	{
		String url="jdbc:mysql://localhost:3306/tabfoods";
		String username="root";
		String password="root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection =DriverManager.getConnection(url, username,password);
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 	
	}

	@Override
	public void addRestaurant(Restaurant restaurant) {
		
		 PreparedStatement statement=null;
		
		try {
			
			statement=connection.prepareStatement(INSERT_QUEARY);
			
			statement.setInt(1,restaurant.getRestaurantId() );
			statement.setString(2,restaurant.getName());
			statement.setString(3,restaurant.getImagePath());
			statement.setFloat(4,restaurant.getRatings());
			statement.setInt(5,restaurant.getEta() );
			statement.setString(6,restaurant.getCuisineType());
			statement.setString(7,restaurant.getAddress() );
			statement.setString(8,restaurant.getIsActive());
			statement.setInt(9,restaurant.getRestaurantOwnerId());
			
			statement.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Restaurant getRestaurant(int restaurantId) {
		PreparedStatement statement=null;
		ResultSet res =null;
		Restaurant restaurant=null;
		
		
		try {
			statement = connection.prepareStatement(SELECT_QUARY);
			statement.setInt(1, restaurantId);
			
			res=statement.executeQuery();
			
			if(res.next())
			{
				
				String name=res.getString("name");
				String imagePath=res.getString("imagePath");
				float ratings=res.getFloat("ratings");
				int eta=res.getInt("eta");
				String cuisineType=res.getString("cuisineType");
				String Address=res.getString("Address");
				String isActive=res.getString("isActive");
				int restaurantOwnerId=res.getInt("restaurantOwnerId");
				
				
				restaurant=new Restaurant(restaurantId, name, imagePath,ratings,eta,  cuisineType, Address, isActive, restaurantOwnerId);
				
//				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	final static String UPDATE_QUARY="UPDATE restaurant"
			+ " SET `name`=?,"
			+ "`imagePath`=?,"
			+ "`ratings`=?,"
			+ "`eta`=?,"
			+ "`cuisineType`=?,"
			+ "`Address`=?,"
			+ "`isActive=?`,"
			+ "`restaurantOwnerId =?` "
			+ "WHERE `restaurantId`=? ";

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		
		 PreparedStatement statement=null;
		
		try {
			statement=connection.prepareStatement(UPDATE_QUARY);
			
			statement.setString(1,restaurant.getName());
			statement.setString(2,restaurant.getImagePath());
			statement.setFloat(3,restaurant.getRatings());
			statement.setInt(4,restaurant.getEta() );
			statement.setString(5,restaurant.getCuisineType());
			statement.setString(6,restaurant.getAddress() );
			statement.setString(7,restaurant.getIsActive());
			statement.setInt(8,restaurant.getRestaurantOwnerId());
			statement.setInt(9,restaurant.getRestaurantId() );
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		 PreparedStatement statement=null;
		
		 try {
			statement=connection.prepareStatement(DELETE_QUARY);
			
			statement.setInt(1, restaurantId);
			
		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		Statement statement=null;
		ResultSet res =null;
		Restaurant restaurant=null;
		
		 ArrayList<Restaurant> RestaurantList =new ArrayList<Restaurant>();
		
		
		try {
			statement= connection.createStatement();
			
			res=statement.executeQuery(SELECT_ALL_QUERY);
			
			while(res.next()) 
			{
				int restaurantId =res.getInt("restaurantId");
				String name=res.getString("name");
				String imagePath=res.getString("imagePath");
				float ratings=res.getFloat("ratings");
				int eta=res.getInt("eta");
				String cuisineType=res.getString("cuisineType");
				String Address=res.getString("Address");
				String isActive=res.getString("isActive");
				int restaurantOwnerId=res.getInt("restaurantOwnerId");
				
				restaurant=new Restaurant(restaurantId, name, imagePath, ratings, eta, cuisineType, Address, isActive, restaurantOwnerId);
				
				RestaurantList.add(restaurant);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return RestaurantList;
	}

}
