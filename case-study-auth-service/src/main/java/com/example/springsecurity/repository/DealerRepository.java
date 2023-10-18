package com.example.springsecurity.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.springsecurity.model.Dealer;



public interface DealerRepository extends MongoRepository<Dealer, String> {

}
