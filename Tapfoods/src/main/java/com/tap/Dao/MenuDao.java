package com.tap.Dao;

import java.util.List;

import com.tap.model.Menu;

public interface MenuDao {
	
	void adduser(Menu menu);
	Menu getuser(int menuId);
	void updateuser(Menu menu);
	void deleteuser(int menuId);
	List<Menu> getAlluser();
	List<Menu>getMunu(int restaurantId);

}
