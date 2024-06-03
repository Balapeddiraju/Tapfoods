package com.tap.model;

public class OrderHistory {
	
	private int orderHistoryId;
	private int userId;
	private int menuId;
	
	public OrderHistory() 
	{
		
	}

	public OrderHistory(int orderHistoryId, int userId, int menuId) {
		super();
		this.orderHistoryId = orderHistoryId;
		this.userId = userId;
		this.menuId = menuId;
	}

	public void setOrderHistoryId(int orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getOrderHistoryId() {
		return orderHistoryId;
	}

	public int getUserId() {
		return userId;
	}

	public int getMenuId() {
		return menuId;
	}


}
