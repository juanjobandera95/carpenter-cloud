package com.carpentery.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carpentery.springboot.app.model.CategoryModel;
import com.carpentery.springboot.app.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryModel> getAllCategorias() {
        return categoryRepository.findAll();
    }

    public CategoryModel getCategoriaById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public CategoryModel createCategoria(CategoryModel categoria) {
        return categoryRepository.save(categoria);
    }

    public CategoryModel updateCategoria(Long id, CategoryModel categoria) {
        if (categoryRepository.existsById(id)) {
            categoria.setId(id);
            return categoryRepository.save(categoria);
        }
        return null; // Manejar el caso en el que la categoría no exista
    }

    public void deleteCategoria(Long id) {
    	categoryRepository.deleteById(id);
    }
}
