package com.carpentery.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
//@RequestMapping("/cloud")

public class ApiController {
	 @GetMapping("/jobs")
	   public static String getAll() {
		 return "";
	 }
	 
}
