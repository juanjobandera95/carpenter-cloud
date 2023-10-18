package com.carpentery.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carpentery.springboot.app.model.TipoModel;

public interface TipoRepository extends JpaRepository<TipoModel, Integer> {
}

