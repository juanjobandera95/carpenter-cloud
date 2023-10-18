package com.carpentery.springboot.app.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="job")
public class JobModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "job_image")
    private String jobImage;

    @Column(name = "job_name")
    private String jobName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryModel category;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private TipoModel tipo;
	
    // Constructor sin argumentos (constructor por defecto)
    public JobModel() {
    }
	public JobModel(String jobName, String jobDescription, String jobImage
			) {
	
		this.jobName = jobName;
		this.jobDescription = jobDescription;
		this.jobImage  = jobImage;
		
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


	
	
	
	
	
}
