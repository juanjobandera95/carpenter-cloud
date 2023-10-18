package com.carpentery.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carpentery.springboot.app.model.JobModel;
import com.carpentery.springboot.app.repository.JobRepository;
@RestController
//@RequestMapping("/cloud")

public class ApiController {
	
    @Autowired
    private JobRepository jobRepository;
	 @GetMapping("/jobs")
	   public Iterable<JobModel>getAll() {
		 return jobRepository.findAll();
	 }
	 
}
