package com.tap.model;

public class Restaurant {
	private int  restaurantId;
	private String name;
	private String imagePath;
	private float ratings;
	private int eta ;
	private String cuisineType;
	private String Address;
	private String isActive;
	private int restaurantOwnerId;
	
	public Restaurant()
	{
		
	}

	public Restaurant(int restaurantId, String name, String imagePath, float ratings, int eta, String cuisineType,
			String address, String isActive, int restaurantOwnerId) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.imagePath = imagePath;
		this.ratings = ratings;
		this.eta = eta;
		this.cuisineType = cuisineType;
		Address = address;
		this.isActive = isActive;
		this.restaurantOwnerId = restaurantOwnerId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public void setRatings(float ratings) {
		this.ratings = ratings;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public void setRestaurantOwnerId(int restaurantOwnerId) {
		this.restaurantOwnerId = restaurantOwnerId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public String getName() {
		return name;
	}

	public String getImagePath() {
		return imagePath;
	}

	public float getRatings() {
		return ratings;
	}

	public int getEta() {
		return eta;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public String getAddress() {
		return Address;
	}

	public String getIsActive() {
		return isActive;
	}

	public int getRestaurantOwnerId() {
		return restaurantOwnerId;
	}
	
	
	

}
