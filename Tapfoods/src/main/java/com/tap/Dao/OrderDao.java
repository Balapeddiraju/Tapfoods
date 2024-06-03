package com.tap.Dao;

import java.util.List;

import com.tap.model.Order;
import com.tap.model.Users;

public interface OrderDao {
	void addorder(Order order);
	Order getorder(int orderId);
	void updateorder(Order order);
	void deleteorder(int orderId);
	List<Order> getAllorder();
}
