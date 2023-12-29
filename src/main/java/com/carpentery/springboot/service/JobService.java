package com.carpentery.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carpentery.springboot.app.model.CategoryModel;
import com.carpentery.springboot.app.model.JobModel;
import com.carpentery.springboot.app.model.TipoModel;
import com.carpentery.springboot.app.repository.JobRepository;

@Service
public class JobService {
	
	@Autowired
    private JobRepository jobRepository;
	 public List<JobModel> getAllJobs() {
	        return jobRepository.findAll();
	    }
	
	  public JobModel getJobById(Long id) {
	        return jobRepository.findById(id).orElse(null);
	    }
	  
	  public void updateJob(JobModel jobModel) {
	        jobRepository.save(jobModel);
	    }

	    public void deleteJob(Long id) {
	        jobRepository.deleteById(id);
	    }
	    
	    public List<JobModel> findByCategory(CategoryModel category) {
	        return jobRepository.findByCategory(category);
	    }

	    public List<JobModel> findByTipo(TipoModel tipo) {
	        return jobRepository.findByTipo(tipo);
	    }
}
