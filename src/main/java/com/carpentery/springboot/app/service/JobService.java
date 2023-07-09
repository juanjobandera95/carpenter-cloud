package com.carpentery.springboot.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carpentery.springboot.app.model.JobModel;
import com.carpentery.springboot.app.repository.JobRespository;

@Service
public class JobService {
	@Autowired
	JobRespository jobRepository;
	
	public ArrayList<JobModel>getAllJobs(){
		return(ArrayList<JobModel>) jobRepository.findAll();
	}

}
