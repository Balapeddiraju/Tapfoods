package com.tap.model;

import java.text.DecimalFormat;

public class Menu {
	private int menuId;
	private String name;
	private float price;
	private String descripation;
	private String imagepath;
	private Boolean isAvailable;
	private int restaurantId;
	private float rating;
	
	public Menu()
	{
		
	}

	public Menu(int menuId, String name, float price, String descripation, String imagepath, Boolean isAvailable,
			int restaurantId, float rating) {
		super();
		this.menuId = menuId;
		this.name = name;
		this.price = price;
		this.descripation = descripation;
		this.imagepath = imagepath;
		this.isAvailable = isAvailable;
		this.restaurantId = restaurantId;
		this.rating = rating;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setDescripation(String descripation) {
		this.descripation = descripation;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getMenuId() {
		return menuId;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

	public String getDescripation() {
		return descripation;
	}

	public String getImagepath() {
		return imagepath;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public float getRating() {
		return rating;
	}
	
	
	

}
