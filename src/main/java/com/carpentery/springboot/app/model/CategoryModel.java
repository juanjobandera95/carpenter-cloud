package com.carpentery.springboot.app.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="category")
public class CategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Long id;
    
    @Column(name = "name_category")
    private String nameCategory;
    
    @Column(name = "description_category")
    private String descriptionCategory;
    
    @Column(name = "image_category")
    private String imageCategory;

 // En CategoryModel, asegúrate de que la relación bidireccional esté configurada correctamente
    /*@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<JobModel> jobses;*/

    
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("category")
    private Set<JobModel> jobs;
	public String getNameCategory() {
		return nameCategory;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public String getDescriptionCategory() {
		return descriptionCategory;
	}

	public void setDescriptionCategory(String descriptionCategory) {
		this.descriptionCategory = descriptionCategory;
	}

	public String getImageCategory() {
		return imageCategory;
	}

	public void setImageCategory(String imageCategory) {
		this.imageCategory = imageCategory;
	}

	public Set<JobModel> getJobs() {
		return jobs;
	}

	public void setJobs(Set<JobModel> jobs) {
		this.jobs = jobs;
	}

	
}