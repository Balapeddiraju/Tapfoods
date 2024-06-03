package com.tap.Dao;

import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.tap.model.OrderHistory;

public interface OrderHistoryDao {
	
	void addOrderHistory(OrderHistory orderHistory);
	OrderHistory getOrderHistory(int orderHistoryId);
	void updateOrderHistory(OrderHistory orderHistory);
	void deleteOrderHistory(int orderHistoryId);
	List<OrderHistory> getAllOrderHistory();

}
