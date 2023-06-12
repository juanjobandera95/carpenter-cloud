package com.carpentery.springboot.app;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 
public class GlobalExceptionHandler {
	 @ExceptionHandler(RuntimeException.class)
	    public String handleRuntimeException(RuntimeException ex, Model model) {
	        model.addAttribute("errorMessage", ex.getMessage());
	        return "error"; // Retorna el nombre de tu página de error personalizada
	    }
}
