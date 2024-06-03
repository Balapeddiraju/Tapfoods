package com.tap.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.Dao.UsersDao;

import com.tap.model.Users;

public class UserDeoImpl implements UsersDao {
	
	final static String Insert_query="insert into `users` "
			+"(`userId`,`name`,`email`,`phoneNo`,`Address`,`username`,`password`,`role`)"
			+"values(?,?,?,?,?,?,?,?)";
	final static String Select_quary="select * from `users` WHERE `userId`=?";
	final static String Update_query="Update users SET `name`=?,`email`=?,`phoneNo`=?,`Address`=?,`username`=?,`password`=?`role=?` WHERE `userId`=?";
	final static String Delete_quary="delete from `users` WHERE `userId`=?";
	final static String Select_All_quary="Select * from `users`";
	final static String SELECT_By_USERNAME="Select `password` from `users` where `username`=?";
	
	final static String  SELECT_QUERYU="Select * from `users` where `username`=?";
	
	
	private static Connection connection;
	public UserDeoImpl()
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
	public void adduser(Users user) {
		PreparedStatement statement;
		try {
			statement=connection.prepareStatement(Insert_query);
			statement.setInt(1, user.getuserId());
			statement.setString(2, user.getname());
			statement.setString(3, user.getemail());
			statement.setInt(4, user.getphoneNo());
			statement.setString(5, user.getAddress());
			statement.setString(6, encription(user.getusername()));
			statement.setString(7, encription(user.getpassword()));
			statement.setString(8, user.getrole());
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Users getuser(int userId) {
		PreparedStatement statement;
		
		ResultSet res=null;
		Users user=null;
		
		try {
			statement =connection.prepareStatement(Select_quary);
			
			statement.setInt(1,userId);
			
			statement.executeQuery();
			
			if(res.next())
			{
				
				String name=res.getString("name");
				String email=res.getString("email");
				int phoneNo=res.getInt("phoneNo");
				String Address=res.getString("Address");
				String username=res.getString("username");
				String password=res.getString("password");
				String role=res.getString("role");
				
				 user = new Users(userId,name,email,phoneNo,Address,decription(username),decription(password),role);
				
			}
		

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return  user;
	}

	@Override
	public void updateuser(Users user) {
		PreparedStatement statement;
		try {
			statement=connection.prepareStatement(Update_query);
			 
	          statement.setInt(1,user.getuserId());
	          statement.setString(2,user.getname());
	          statement.setString(3,user.getemail());
	          statement.setInt(4,user.getphoneNo());
	          statement.setString(5,user.getAddress());
	          statement.setString(6,user.getusername());
	          statement.setString(7,user.getpassword());
	          statement.setString(8,user.getrole());
	          
	          statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteuser(int userid) {
		PreparedStatement statement;
		
		 try {
			statement=connection.prepareStatement(Delete_quary);
			
			statement.setInt(1, userid);
			 statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Users> getAlluser() {
		
		Statement statement=null;
		ResultSet res=null;
		Users user=null;
		
		ArrayList<Users> userList=new ArrayList<Users>();
		
		try {
			statement= connection.createStatement();
			res=statement.executeQuery(Select_All_quary);
			while(res.next())
			{
				int userId =res.getInt("userId");
				String name=res.getString("name");
				String email=res.getString("email");
				int phoneNo=res.getInt("phoneno");
				String Address=res.getString("adress");
				String username=res.getString("Username");
				String password=res.getString("Password");
				String role=res.getString("role");
				
				user= new Users(userId, name, email, phoneNo, Address, decription(username), decription(password), role);
				
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return userList;
	}


	

	public Users getUserLogin(String username) {
		PreparedStatement pstmt=null;
		ResultSet res=null;
		Users users=null;
		try {
			pstmt =connection.prepareStatement(SELECT_QUERYU);
			pstmt.setString(1, encription(username));
			
			res =pstmt.executeQuery();
			
			if(res.next()) {
			int userId =res.getInt("userId");
			String name =res.getString("name");
			String email=res.getString("email");
			int phoneNo=res.getInt("phoneNo");
			String Address=res.getString("Address");
			String password=res.getString("password");
			String role=res.getString("role");
			
			 users = new Users(userId,name,email,phoneNo,Address,username,decription(password),role);
			
			}
			
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
		return users;
	}
	
	public static String encription (String s) {
		String t="";
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			int x=c+5;
			char g=(char)x;
		//	
			t=t+g;
		}
		return t;
	}
	public static String decription(String s) {
		String t="";
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			int x=c-5;
			char g=(char)x;
//			c=(char)(c-1);
			t=t+g;
		}
		return t;
	}


	

}
