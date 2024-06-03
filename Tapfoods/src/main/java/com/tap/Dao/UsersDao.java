package com.tap.Dao;

import java.util.List;

import com.tap.model.Menu;
import com.tap.model.Users;
import com.tap.model.Users;

public interface UsersDao {
	void adduser(Users user);
	Users getuser(int userId);
	void updateuser(Users user);
	void deleteuser(int userId);
	List<Users> getAlluser();
	

}
