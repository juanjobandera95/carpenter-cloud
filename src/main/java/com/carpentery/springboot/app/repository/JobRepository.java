package com.carpentery.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carpentery.springboot.app.model.JobModel;

@Repository
public interface JobRepository extends JpaRepository<JobModel,Long> {

}
