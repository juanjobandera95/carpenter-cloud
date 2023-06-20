package com.carpentery.springboot.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Tipo {
	@Column(name = "idTipo")	
	private int idTipo;
	@Column(name = "nameType")	
	private String nameType;
	@Column(name = "imageType")	
	private String imageType;
	@Column(name = "descriptionType")	
	private String description;
	
	
	
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
