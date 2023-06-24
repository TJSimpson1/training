package com.fdmgroup.employeeApiTravisSimpson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmployeeApiTravisSimpsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApiTravisSimpsonApplication.class, args);
	}

}
