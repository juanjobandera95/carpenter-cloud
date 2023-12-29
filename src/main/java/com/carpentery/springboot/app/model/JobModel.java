package com.carpentery.springboot.app.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="job")
public class JobModel {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name_job")
    private String nameJob;
    @Column(name = "descripcion_job")
    private String descriptionJob;
    @Column(name = "image_job")
    private String imageJob;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("jobs")
    private CategoryModel category;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    @JsonIgnoreProperties("jobs")
    private TipoModel tipo;
    
    
	public JobModel() {
		
	}

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombreTipo() {
		return this.tipo.getNameType();
	}
	
	public String getNombreCategoria() {
		return this.category.getNameCategory();
	}
	public String getNameJob() {
		return nameJob;
	}

	public void setNameJob(String nameJob) {
		this.nameJob = nameJob;
	}

	public String getDescriptionJob() {
		return descriptionJob;
	}

	public void setDescriptionJob(String descriptionJob) {
		this.descriptionJob = descriptionJob;
	}

	public String getImageJob() {
		return imageJob;
	}

	public void setImageJob(String imageJob) {
		this.imageJob = imageJob;
	}

	public CategoryModel getCategory() {
		return category;
	}

	public void setCategory(CategoryModel category) {
		this.category = category;
	}

	public TipoModel getTipo() {
		return tipo;
	}

	public void setTipo(TipoModel tipo) {
		this.tipo = tipo;
	}

}
