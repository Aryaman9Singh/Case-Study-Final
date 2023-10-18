package com.example.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.springsecurity.model.Dealer;
import com.example.springsecurity.model.Farmer;

@Service
public class DealerService {
	@Autowired
	RestTemplate restTemplate;
	public ResponseEntity<String> addDealer(String did, Dealer dealer)
	{

		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Dealer> request = new HttpEntity<>(dealer, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(
        		"http://localhost:8090/dealer-service/addDealer",
            request,
            String.class
        );

        // Handle the response as needed
        return response;
	}
	

}
