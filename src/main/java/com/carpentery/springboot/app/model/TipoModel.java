package com.carpentery.springboot.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo")

public class TipoModel {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	
	private int idTipo;
	@Column(name = "nameType")	
	private String nameType;
	@Column(name = "imageType")	
	private String imageType;
	@Column(name = "descriptionType")	
	private String description;
	
	
	
	public TipoModel(String nameType, String imageType, String description) {
		
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


	
}
