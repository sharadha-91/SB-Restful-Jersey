package com.app;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.dao.EmployeeRepository;
import com.app.model.Employee;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SbRestServicesJerseyApplication {

	@Autowired
	private EmployeeRepository empRepo;
	
	//before main this method executes and save to db
	@PostConstruct
	public void initDatabase() {
		empRepo.saveAll(Stream.of(
				new Employee("Harsha","IT"),
				new Employee("Vani","Accounts"),
				new Employee("Shamili","HR")).collect(Collectors.toList()));
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SbRestServicesJerseyApplication.class, args);
	}

}
