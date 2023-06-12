package com.carpentery.springboot.app.entity;
//@Entity
public class Tipo {
	private int idTipo;
	private String nameType;
	private String imageType;
	private String description;
	private int typeId;
	private int categoryId;
	
	
	public Tipo(String nameType, String imageType, String description) {
		
		this.nameType = nameType;
		this.imageType = imageType;
		this.description = description;
		
	}


	public int getIdTipo() {
		return idTipo;
	}


	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}


	public String getNameType() {
		return nameType;
	}


	public void setNameType(String nameType) {
		this.nameType = nameType;
	}


	public String getImageType() {
		return imageType;
	}


	public void setImageType(String imageType) {
		this.imageType = imageType;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getTypeId() {
		return typeId;
	}


	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

}
