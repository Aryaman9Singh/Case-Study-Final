package com.casestudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

@SpringBootApplication
public class CaseStudyCropdetailServiceApplication {

//	@LoadBalanced
	public static void main(String[] args) {
		SpringApplication.run(CaseStudyCropdetailServiceApplication.class, args);
	}

}
