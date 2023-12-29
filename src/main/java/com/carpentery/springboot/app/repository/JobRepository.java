package com.carpentery.springboot.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carpentery.springboot.app.model.CategoryModel;
import com.carpentery.springboot.app.model.JobModel;
import com.carpentery.springboot.app.model.TipoModel;

@Repository
public interface JobRepository extends JpaRepository<JobModel,Long> {
	List<JobModel> findByCategory(CategoryModel category);
    List<JobModel> findByTipo(TipoModel tipo);
}
