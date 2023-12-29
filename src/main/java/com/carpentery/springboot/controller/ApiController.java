package com.carpentery.springboot.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import com.carpentery.springboot.service.JobService;
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

        @DeleteMapping("/delete/{id}")
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
        
        @GetMapping("/categories")
  	   public List<CategoryModel> getAllCategories() {
  		 List<CategoryModel> cat = categoryRepository.findAll();
  	        
  	        
  	        return cat;
  	 }
    }
