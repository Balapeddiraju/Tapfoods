package com.tap.model;

public class OrderItems {
	private int orderItemId;
	private int userId;
	private int menuId;
	private String name;
	private int quantity;
	private float ratings;
	private float price;
	
	public OrderItems()
	{
		
	}

	public OrderItems(int orderItemId, int userId, int menuId, String name, int quantity, float ratings, float price) {
		super();
		this.orderItemId = orderItemId;
		this.userId = userId;
		this.menuId = menuId;
		this.name = name;
		this.quantity = quantity;
		this.ratings = ratings;
		this.price = price;
	}

	public OrderItems(int menuId2, String menuName, int i, float price2, int restaurantId) {
		// TODO Auto-generated constructor stub
	}


	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setRatings(float ratings) {
		this.ratings = ratings;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public int getUserId() {
		return userId;
	}

	public int getMenuId() {
		return menuId;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public float getRatings() {
		return ratings;
	}

	public float getPrice() {
		return price;
	}
	
}
