package com.carpentery.springboot.app.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="tipo")

public class TipoModel {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_tipo")
	    private int idTipo;

	    @Column(name = "description_type")
	    private String descriptionType;

	    @Column(name = "image_type")
	    private String imageType;

	    @Column(name = "name_type")
	    private String nameType;
	
	    @OneToMany(mappedBy = "tipo")
	    @JsonManagedReference
	    private List<JobModel> jobs;

	    
	    // Constructor sin argumentos (constructor por defecto)
	    public TipoModel() {
	    }
	public TipoModel(String nameType, String imageType, String description) {
		
		this.nameType = nameType;
		this.imageType = imageType;
		this.descriptionType = description;
		
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
		return descriptionType;
	}


	public void setDescription(String description) {
		this.descriptionType = description;
	}


	
}
