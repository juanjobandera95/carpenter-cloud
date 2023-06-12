package com.carpentery.springboot.app.entity;

import java.util.ArrayList;

public class Job {
	private int id;
	private String jobName;
	private String jobDescription;
	private String jobImage;
	private ArrayList<Category> listaCategories;
	private ArrayList<Tipo> listaTipos;
	
	
	public Job(String jobName, String jobDescription, String jobImage
			) {
	
		this.jobName = jobName;
		this.jobDescription = jobDescription;
		this.jobImage = jobImage;
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
