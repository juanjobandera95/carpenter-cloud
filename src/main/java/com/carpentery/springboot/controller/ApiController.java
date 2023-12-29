package com.carpentery.springboot.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.carpentery.springboot.app.model.CategoryModel;
import com.carpentery.springboot.app.model.JobModel;
import com.carpentery.springboot.app.model.TipoModel;
import com.carpentery.springboot.app.repository.CategoryRepository;
import com.carpentery.springboot.app.repository.JobRepository;
import com.carpentery.springboot.app.repository.TipoRepository;
import com.carpentery.springboot.service.CategoryService;
import com.carpentery.springboot.service.JobService;
import com.carpentery.springboot.service.TipoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
    @RestController
    @RequestMapping("/api/v1")
    public class ApiController {
        @Autowired
        private JobRepository jobRepository;

        @Autowired
        private CategoryRepository categoryRepository;

        @Autowired
        private TipoRepository tipoRepository;
     
        @Autowired
        private JobService jobService;
        
        @Autowired
        private CategoryService categoryService;
        
        @Autowired
        private TipoService tipoService;
        @PostMapping("/jobs/create")
        public ResponseEntity<String> createJob(@RequestBody JobModel jobModel) {
        	
        	 TipoModel tipo = tipoRepository.findById(jobModel.getTipo().getId()).orElseThrow(() -> new RuntimeException("Tipo no encontrado"));
             CategoryModel category = categoryRepository.findById(jobModel.getCategory().getId()).orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

             jobModel.setTipo(tipo);
             jobModel.setCategory(category);

        	jobRepository.save(jobModel); // Asume que tienes un método createJob en tu servicio
            return new ResponseEntity<>("Job creado exitosamente", HttpStatus.CREATED);
        }
        
        
        @GetMapping("/jobs")
        public List<Map<String, Object>> getAllJobs() {
            List<JobModel> jobs = jobService.getAllJobs();

            return jobs.stream()
                    .map(job -> {
                        Map<String, Object> jobMap = new HashMap<>();
                        jobMap.put("nameJob", job.getNameJob());
                        jobMap.put("descriptionJob", job.getDescriptionJob());
                        jobMap.put("imageJob", job.getImageJob());

                        // Verificar si la categoría no es nula antes de acceder a sus propiedades
                        if (job.getCategory() != null) {
                            jobMap.put("nombreCategoria", job.getCategory().getNameCategory());
                        }

                        // Similarmente, verifica si el tipo no es nulo antes de acceder a sus propiedades
                        if (job.getTipo() != null) {
                            jobMap.put("nombreTipo", job.getTipo().getNameType());
                        }

                        return jobMap;
                    })
                    .collect(Collectors.toList());
        }
        
      
        @PutMapping("/job/update/{id}")
        public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody JobModel updatedJobModel) {
            // Verificar si el trabajo existe
            JobModel existingJob = jobService.getJobById(id);     
            if (existingJob == null) {
                return new ResponseEntity<>("Trabajo no encontrado", HttpStatus.NOT_FOUND);
            }

            // Asegúrate de que las instancias de TipoModel y CategoryModel ya existan
            TipoModel tipo = tipoRepository.findById(updatedJobModel.getTipo().getId()).orElseThrow(() -> new RuntimeException("Tipo no encontrado"));
            CategoryModel category = categoryRepository.findById(updatedJobModel.getCategory().getId()).orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

            // Actualiza las propiedades del trabajo existente
            existingJob.setNameJob(updatedJobModel.getNameJob());
            existingJob.setDescriptionJob(updatedJobModel.getDescriptionJob());
            existingJob.setImageJob(updatedJobModel.getImageJob());
            existingJob.setTipo(tipo);
            existingJob.setCategory(category);

            // Guarda la actualización
            jobService.updateJob(existingJob);

            return new ResponseEntity<>("Trabajo actualizado exitosamente", HttpStatus.OK);
        }
    

     
        @GetMapping("/jobs/{jobId}")
        public JobModel getJobById(@PathVariable Long jobId) {
            return jobRepository.findById(jobId).orElse(null);
        }
        
        @GetMapping("/category/{categoryId}")
        public CategoryModel getCategoryById(@PathVariable Long categoryId) {
            return categoryRepository.findById(categoryId).orElse(null);
        }
        
        @GetMapping("/tipo/{tipoId}")
        public TipoModel getTipoById(@PathVariable Long tipoId) {
            return tipoRepository.findById(tipoId).orElse(null);
        }

        @GetMapping("/categories")
        public List<CategoryModel>  getAllCategories() {
            List<CategoryModel> categories = categoryService.getAllCategorias();
            return categories;
        }
        
        @GetMapping("/types")
        public List<TipoModel>  getAllCategoriess() {
            List<TipoModel> tipos = tipoService.getAllTipos();
            return tipos;
        }

         
        @DeleteMapping("/job/{id}")
        public ResponseEntity<String> deleteJob(@PathVariable Long id) {
            // Verificar si el trabajo existe antes de intentar eliminarlo
            JobModel existingJob = jobService.getJobById(id);
            if (existingJob == null) {
                return new ResponseEntity<>("Trabajo no encontrado", HttpStatus.NOT_FOUND);
            }

            // Eliminar el trabajo
            jobService.deleteJob(id);

            return new ResponseEntity<>("Trabajo eliminado exitosamente", HttpStatus.OK);
        }
        
 
        @DeleteMapping("/category/{id}")
        public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
            // Verificar si el trabajo existe antes de intentar eliminarlo
            CategoryModel existingCategory = categoryService.getCategoriaById(id);
            if (existingCategory == null) {
                return new ResponseEntity<>("Trabajo no encontrado", HttpStatus.NOT_FOUND);
            }

            // Eliminar el trabajo
            categoryService.deleteCategoria(id);

            return new ResponseEntity<>("Trabajo eliminado exitosamente", HttpStatus.OK);
        }
        
        @DeleteMapping("/tipo/{id}")
        public ResponseEntity<String> deleteTipo(@PathVariable Long id) {
            // Verificar si el trabajo existe antes de intentar eliminarlo
            TipoModel existingTipo = tipoService.getTipoById(id);
            if (existingTipo == null) {
                return new ResponseEntity<>("Trabajo no encontrado", HttpStatus.NOT_FOUND);
            }

            // Eliminar el trabajo
            tipoService.deleteTipo(id);

            return new ResponseEntity<>("Trabajo eliminado exitosamente", HttpStatus.OK);
        }
        // Obtener trabajos por tipo
        @GetMapping("/tipos/{tipoId}/jobs")
        public List<JobModel> getTrabajosByTipo(@PathVariable Long tipoId) {
            TipoModel tipo = tipoRepository.findById(tipoId).orElse(null);
            if (tipo != null) {
                return jobRepository.findByTipo(tipo);
            }
            return Collections.emptyList();
        }

        // Obtener trabajos por categoría
        @GetMapping("/categories/{categoriaId}/jobs")
        public List<JobModel> getTrabajosByCategoria(@PathVariable Long categoriaId) {
            CategoryModel category = categoryRepository.findById(categoriaId).orElse(null);
            if (category != null) {
                return jobRepository.findByCategory(category);
            }
            return Collections.emptyList();
        }
        
        // Endpoint para crear un nuevo tipo
        @PostMapping("/type/create")
        public ResponseEntity<String> createType(@RequestBody TipoModel typeModel) {
        	tipoService.createTipo(typeModel);
            return new ResponseEntity<>("Tipo creado exitosamente", HttpStatus.CREATED);
        }

        // Endpoint para actualizar un tipo existente
        @PutMapping("/type/update/{id}")
        public ResponseEntity<String> updateType(@PathVariable Long id, @RequestBody TipoModel updatedType) {
        	tipoService.updateTipo(id, updatedType);
            return new ResponseEntity<>("Tipo actualizado exitosamente", HttpStatus.OK);
        }

        // Endpoint para crear una nueva categoría
        @PostMapping("/category/create")
        public ResponseEntity<String> createCategory(@RequestBody CategoryModel categoryModel) {
            categoryService.createCategoria(categoryModel);
            return new ResponseEntity<>("Categoría creada exitosamente", HttpStatus.CREATED);
        }

        // Endpoint para actualizar una categoría existente
        @PutMapping("/category/update/{id}")
        public ResponseEntity<String> updateCategory(@PathVariable Long id, @RequestBody CategoryModel updatedCategory) {
            categoryService.updateCategoria(id, updatedCategory);
            return new ResponseEntity<>("Categoría actualizada exitosamente", HttpStatus.OK);
        }
    }
