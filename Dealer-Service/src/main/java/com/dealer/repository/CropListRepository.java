package com.dealer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dealer.model.CropsList;

public interface CropListRepository extends MongoRepository<CropsList, String>{

}
