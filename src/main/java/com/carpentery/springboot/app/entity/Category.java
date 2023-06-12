package com.carpentery.springboot.app.entity;

public class Category {
	private int idCategory;
	private String name;
	private String image;
	private String description;
	
	
	public Category(String name, String image, String description) {
		
		this.name = name;
		this.image = image;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
