package com.casestudy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.model.Crop;
import com.casestudy.repository.CropRepository;

@Service
public class CropService {
	
	@Autowired
	CropRepository cropRepository;
	
//	public Optional<List<Crop>> getCropsEmail(String farmerEmail){
	public List<Crop> getCropsEmail(String farmerEmail){
		return cropRepository.findByFarmerEmail(farmerEmail);		
		
	}
	public Crop getCropEmailCropName(String farmerEmail,String cropName) {
		return cropRepository.findByFarmerEmailAndCropName(farmerEmail, cropName);
	}
	public Crop updateCropInc(String farmerEmail,String cropName,int qty) {
		Crop crop = cropRepository.findByFarmerEmailAndCropName(farmerEmail, cropName);
		System.out.println(crop.getCropName());
		int quantity = Integer.parseInt(crop.getCropqnty());
		quantity+=qty;
		crop.setCropqnty(String.valueOf(quantity));
		cropRepository.save(crop);
		return crop;
	}
	public Crop updateCropDec(String farmerEmail, String cropName, int qty) {
		// TODO Auto-generated method stub
		Crop crop = cropRepository.findByFarmerEmailAndCropName(farmerEmail, cropName);
		System.out.println(crop.getCropName());
		int quantity = Integer.parseInt(crop.getCropqnty());
		quantity-=qty;
		crop.setCropqnty(String.valueOf(quantity));
		cropRepository.save(crop);
		return crop;
		
	}
	public String deleteCrop(String farmerEmail, String cropName) {
		// TODO Auto-generated method stub
		Crop crop = cropRepository.findByFarmerEmailAndCropName(farmerEmail, cropName);
		cropRepository.delete(crop);
		return "deleted";
	}

}
