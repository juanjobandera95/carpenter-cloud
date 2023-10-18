package com.carpentery.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carpentery.springboot.app.model.JobModel;
import com.carpentery.springboot.app.repository.JobRepository;
@RestController
public class ApiController {
	
    @Autowired
    private JobRepository jobRepository;
	 @GetMapping("/jobs")
	   public Iterable<JobModel>getAll() {
		 List<JobModel> jobs = jobRepository.findAll();
	        // Personalizar las respuestas JSON para incluir el nombre de la categoría y el tipo
	        jobs.forEach(job -> {
	            job.getCategory().setName(job.getCategory().getName());
	            job.getTipo().setNameType(job.getTipo().getNameType());
	        });
	        
	        return jobs;
	 }
	 
}
