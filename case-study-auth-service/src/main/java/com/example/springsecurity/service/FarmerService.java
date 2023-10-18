package com.example.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.springsecurity.model.Farmer;


@Service
public class FarmerService {
	@Autowired
	RestTemplate restTemplate;
	
	public ResponseEntity<String> addFarmer(String fid, Farmer farmer)
	{

		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Farmer> request = new HttpEntity<>(farmer, headers);

        System.out.println("hellofarmerauth service");
        ResponseEntity<String> response = restTemplate.postForEntity(
        		"http://localhost:8090/farmer-service/addFarmer",
            request,
            String.class
        );

        // Handle the response as needed
        return response;
	}
	
}
