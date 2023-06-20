package com.carpentery.springboot.app.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="job")
public class JobModel {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	
	private int id;
	@Column(name = "jobName")
	private String jobName;
	@Column(name = "jobDescription")	

	private String jobDescription;
	@Column(name = "jobImage")	

	private String jobImage;
	@Column(name = "categoryId")	

	private ArrayList<CategoryModel> listaCategories;
	@Column(name = "tipoId")	

	private ArrayList<TipoModel> listaTipos;
	
	
	public JobModel(String jobName, String jobDescription, String jobImage
			) {
	
		this.jobName = jobName;
		this.jobDescription = jobDescription;
		this.jobImage  = jobImage;
		this.listaCategories =new ArrayList<CategoryModel>();
		this.listaTipos = new ArrayList<TipoModel>();
	}


	public String getJobName() {
		return jobName;
	}


	public void setJobName(String jobName) {
		this.jobName = jobName;
	}


	public String getJobDescription() {
		return jobDescription;
	}


	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}


	public String getJobImage() {
		return jobImage;
	}


	public void setJobImage(String jobImage) {
		this.jobImage = jobImage;
	}


	public ArrayList<CategoryModel> getListaCategories() {
		return listaCategories;
	}


	public void addListaCategories(CategoryModel category) {
		this.listaCategories.add(category);
	}


	public ArrayList<TipoModel> getListaTipos() {
		return listaTipos;
	}


	public void addListaTipos(TipoModel tipo) {
		this.listaTipos.add(tipo);
	}

	
	
	
	
}
