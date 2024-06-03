package com.tap.model;

public class Order {
//	orderId, restaurantId, userId, totalAmount, modeofPayment, status
	private int orderId;
	private int restaurantId;
	private int userId;
	private int totalAmount;
	private String modeofPayment;
	private String status;
	
	public Order()
	{
		
	}

	public Order(int orderId, int restaurantId, int userId, int totalAmount, String modeofPayment, String status) {
		super();
		this.orderId = orderId;
		this.restaurantId = restaurantId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.modeofPayment = modeofPayment;
		this.status = status;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setModeofPayment(String modeofPayment) {
		this.modeofPayment = modeofPayment;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getOrderId() {
		return orderId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public int getUserId() {
		return userId;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public String getModeofPayment() {
		return modeofPayment;
	}

	public String getStatus() {
		return status;
	}
	

}
