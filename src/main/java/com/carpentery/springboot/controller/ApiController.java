package com.carpentery.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carpentery.springboot.app.model.CategoryModel;
import com.carpentery.springboot.app.model.JobModel;
import com.carpentery.springboot.app.model.TipoModel;
import com.carpentery.springboot.app.repository.CategoryRepository;
import com.carpentery.springboot.app.repository.JobRepository;
import com.carpentery.springboot.app.repository.TipoRepository;
@RestController
public class ApiController {
	
    @Autowired
    private JobRepository jobRepository;
	 
    @Autowired
    private CategoryRepository categoryRepository;
	 
    @Autowired
    private TipoRepository tipoRepository;
	 
    
    
    @GetMapping("/jobs")
	   public List<JobModel> getAll() {
		 List<JobModel> jobs = jobRepository.findAll();
	        // Personalizar las respuestas JSON para incluir el nombre de la categoría y el tipo
	        jobs.forEach(job -> {
	            job.getCategory().setName(job.getCategory().getName());
	            job.getTipo().setNameType(job.getTipo().getNameType());
	        });
	        
	        return jobs;
	 }
	 
    @GetMapping("/categories")
	   public List<CategoryModel> getAllCategories() {
		 List<CategoryModel> cat = categoryRepository.findAll();
	        
	        
	        return cat;
	 }
    
    
    @GetMapping("/types")
	   public List<TipoModel> getAlltypes() {
		 List<TipoModel> types = tipoRepository.findAll();
	        
	        
	        return types;
	 }
}
