package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RestApiWithoutDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiWithoutDbApplication.class, args);
	}
	
	@GetMapping("/home")
	public String getHome()
	{
		return "This is from rest application which is not using DB";
	}

}
