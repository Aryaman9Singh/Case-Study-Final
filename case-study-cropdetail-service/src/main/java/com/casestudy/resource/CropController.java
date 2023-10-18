package com.casestudy.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.model.Crop;
import com.casestudy.repository.CropRepository;
import com.casestudy.service.CropService;

@RestController
@CrossOrigin(origins = "*")	
@RequestMapping("/crop-service")
public class CropController {
	
	@Autowired
	private CropRepository repository;
	
	@Autowired
	private CropService cropService;
	
	@PostMapping("/addCrop")
	public String addCrop(@RequestBody Crop crop) {
		System.out.println(crop.getCropName());
		repository.save(crop);
		return "added crop with id: " + crop.getCropId();
	}
	
	@GetMapping("/findAllCrops")
	public List<Crop> getCrops(){
		return repository.findAll();
	}
	
	@GetMapping("/findCrop/{id}")
	public Optional<Crop> getCrop(@PathVariable String id){
		return repository.findById(id);
	}
	@GetMapping("/getCropsEmail/{farmerEmail}")
	public List<Crop> getCropsEmail(@PathVariable String farmerEmail){
//		System.out.println(farmerEmail+"from crop mapping");
		return cropService.getCropsEmail(farmerEmail);
	}
	@GetMapping("/getCropsEmailCropName/{farmerEmail}/{cropName}")
	public Crop getCropsEmailCropName(@PathVariable String farmerEmail,@PathVariable String cropName){
		
		return cropService.getCropEmailCropName(farmerEmail,cropName);
	}
	@PutMapping("/updateCropInc/{farmerEmail}/{cropName}/{qty}")
	public Crop updateCropInc(@PathVariable String farmerEmail,@PathVariable String cropName,@PathVariable int qty) {
		System.out.println("updateCropInc "+ farmerEmail+" " +cropName+ " "+qty );
		return cropService.updateCropInc(farmerEmail, cropName, qty);
	}
	@PutMapping("/updateCropDec/{farmerEmail}/{cropName}/{qty}")
	public Crop updateCropDec(@PathVariable String farmerEmail,@PathVariable String cropName,@PathVariable int qty) {
		System.out.println("updateCropDec "+ farmerEmail+" " +cropName+ " "+qty );
		return cropService.updateCropDec(farmerEmail, cropName, qty);
	}
	
//	public List<E>
//	@PutMapping("/updateCrops/{id}")
//	public String updateCrop(@RequestBody Crop crop) {
//		repository.save(crop);
//		return "updated crop with id: " + crop.getFid();
//	}
	
	@DeleteMapping("/deleteCrop/{farmerEmail}/{cropName}")
	public String deleteCrop(@PathVariable String farmerEmail,@PathVariable String cropName) {
		

		return cropService.deleteCrop(farmerEmail,cropName);
		
	}

}
