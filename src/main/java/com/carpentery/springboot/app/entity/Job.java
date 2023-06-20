package com.carpentery.springboot.app.entity;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Job {
	@Id
	private int id;
	@Column(name = "jobName")
	private String jobName;
	@Column(name = "jobDescription")	

	private String jobDescription;
	@Column(name = "jobImage")	

	private String jobImage;
	@Column(name = "categoryId")	

	private ArrayList<Category> listaCategories;
	@Column(name = "tipoId")	

	private ArrayList<Tipo> listaTipos;
	
	
	public Job(String jobName, String jobDescription, String jobImage
			) {
	
		this.jobName = jobName;
		this.jobDescription = jobDescription;
		this.jobImage  = jobImage;
		this.listaCategories =new ArrayList<Category>();
		this.listaTipos = new ArrayList<Tipo>();
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


	public ArrayList<Category> getListaCategories() {
		return listaCategories;
	}


	public void addListaCategories(Category category) {
		this.listaCategories.add(category);
	}


	public ArrayList<Tipo> getListaTipos() {
		return listaTipos;
	}


	public void addListaTipos(Tipo tipo) {
		this.listaTipos.add(tipo);
	}

	
	
	
	
}
