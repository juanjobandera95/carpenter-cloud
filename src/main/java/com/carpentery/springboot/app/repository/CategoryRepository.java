package com.carpentery.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carpentery.springboot.app.model.CategoryModel;


public interface CategoryRepository extends JpaRepository<CategoryModel, Integer> {
}

