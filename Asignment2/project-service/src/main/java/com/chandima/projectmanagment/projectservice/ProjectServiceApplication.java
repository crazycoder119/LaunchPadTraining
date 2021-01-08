package com.chandima.projectmanagment.projectservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//@SpringBootApplication(scanBasePackages = "com.chandima.projectmanagment.projectservice.service.ProjectService")
@SpringBootApplication
@EntityScan(basePackages = "com.chandima.projectmanagement.commons.model.project")
public class ProjectServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectServiceApplication.class, args);
	}

}
