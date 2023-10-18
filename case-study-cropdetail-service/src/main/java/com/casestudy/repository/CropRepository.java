package com.casestudy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.model.Crop;

public interface CropRepository extends MongoRepository<Crop, String> {
	List<Crop> findByFarmerEmail(String farmerEmail);
	Crop findByFarmerEmailAndCropName(String farmerEmail,String cropName);

}
