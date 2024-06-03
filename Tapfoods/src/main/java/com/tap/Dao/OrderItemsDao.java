package com.tap.Dao;

import java.util.List;

import com.tap.model.Menu;
import com.tap.model.OrderItems;

public interface OrderItemsDao {
	
	void addorderItems(OrderItems orderItems);
	OrderItems getorderItems(int orderItemId);
	void updateorderItems(OrderItems orderItems);
	void deleteorderItems(int orderItemId);
	List<OrderItems> getAllorderItems();

}