package com.tap.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.Dao.MenuDao;
import com.tap.model.Menu;
import com.tap.model.Users;

public class MenuDaoImpl implements MenuDao{
	
	final static String INSERT_QUERY="INSERT into `menu` "
			+"(`menuId`,`name`,`price`,`descripation`,`imagepath`,`isAvailable`,`restaurantId`,`rating`)"
			+"values(?,?,?,?,?,?,?,?)";
	final static String SELECT_QUERY="SELECT * from `menu` WHERE `menuId`=?";
	final static String UPDATE_QUERY="UPDATE menu SET `name`=?,`price`=?,`descripation`=?,`imagepath`=?,`isAvailable`=?,`restaurantId`=?`rating=?` WHERE `menuId`=?";
	final static String DELETE_QUERY="DELETE from `menu` WHERE `menuId`=?";
	final static String SELECT_ALL_QUERY="SELECT * from `menu`";
	final static String SELECT_QUERYM="SELECT * from `menu` WHERE `restaurantId`=?";
	private Connection connection;
	public MenuDaoImpl()
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
	public void adduser(Menu menu) {
		PreparedStatement statement;
		try {
			statement=connection.prepareStatement(INSERT_QUERY);
			
			statement.setInt(1, menu.getMenuId());
			statement.setString(2, menu.getName());
			statement.setFloat(3, menu.getPrice());
			statement.setString(4, menu.getDescripation());
			statement.setString(5, menu.getImagepath());
			statement.setBoolean(6, menu.getIsAvailable());
			statement.setInt(7, menu.getRestaurantId());
			statement.setFloat(8, menu.getRating());
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public Menu getuser(int menuId) {
        PreparedStatement statement;
		
		ResultSet res=null;
		Menu menu=null;
		
		try {
			statement =connection.prepareStatement(SELECT_QUERY);
			
			statement.setInt(1,menuId);
			
			statement.executeQuery();
			
			if(res.next())
			{
				
				String name=res.getString("name");
				Float price=res.getFloat("price");
				String descripation=res.getString("descripation");
				String imagepath=res.getString("imagepath");
				Boolean isAvailable=res.getBoolean("isAvailable");
				int restaurantId=res.getInt("restaurantId");
				Float rating=res.getFloat("rating");
				
				menu = new Menu(menuId, name, price, descripation, imagepath, isAvailable, restaurantId, rating);
				
			}
		

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return  menu;
	
	}

	@Override
	public void updateuser(Menu menu) {
		PreparedStatement statement;
		try {
			statement=connection.prepareStatement(UPDATE_QUERY);
			 
	          statement.setInt(1,menu.getMenuId());
	          statement.setString(2,menu.getName());
	          statement.setFloat(3,menu.getPrice());
	          statement.setString(4,menu.getDescripation());
	          statement.setString(5,menu.getImagepath());
	          statement.setBoolean(6,menu.getIsAvailable());
	          statement.setInt(7,menu.getRestaurantId());
	          statement.setFloat(8,menu.getRating());
	          
	          statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteuser(int menuId) {
		PreparedStatement statement;
		
		 try {
			statement=connection.prepareStatement(DELETE_QUERY);
			
			statement.setInt(1, menuId);
			 statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Menu> getAlluser() {
		Statement statement=null;
		ResultSet res=null;
		Menu menu=null;
		
		ArrayList<Menu> menuList=new ArrayList<Menu>();
		
		try {
			statement= connection.createStatement();
			res=statement.executeQuery(SELECT_ALL_QUERY);
			while(res.next())
			{
				int menuId =res.getInt("menuId");
				String name=res.getString("name");
				Float price=res.getFloat("price");
				String descripation=res.getString("descripation");
				String imagepath=res.getString("imagepath");
				Boolean isAvailable=res.getBoolean("isAvailable");
				int restaurantId=res.getInt("restaurantId");
				Float rating=res.getFloat("rating");
				
				menu= new Menu(menuId, name, price, descripation, imagepath, isAvailable, restaurantId, rating);
				
				menuList.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return menuList;
	
	}

	@Override
	public List<Menu> getMunu(int restaurantId) {
     PreparedStatement statement;
		
		ResultSet res=null;
		Menu menu=null;
		ArrayList<Menu> menuList=new ArrayList<Menu>();
		try {
			statement =connection.prepareStatement(SELECT_QUERYM);
			
			statement.setInt(1,restaurantId);
			
			res = statement.executeQuery();
			
			while(res.next())
			{
				
				String name=res.getString("name");
				Float price=res.getFloat("price");
				String descripation=res.getString("descripation");
				String imagepath=res.getString("imagepath");
				Boolean isAvailable=res.getBoolean("isAvailable");
				int menuId=res.getInt("menuId");
				Float rating=res.getFloat("rating");
				
				menu= new Menu(menuId, name, price, descripation, imagepath, isAvailable, restaurantId, rating);
				
				menuList.add(menu);
				
			}
		

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return menuList;
	}

}
