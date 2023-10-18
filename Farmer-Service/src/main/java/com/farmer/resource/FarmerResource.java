package com.farmer.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.farmer.model.Crops;
import com.farmer.model.Farmer;
import com.farmer.model.FarmerList;
import com.farmer.repository.FarmerRepository;
import com.farmer.service.FarmerService;


@RestController
@CrossOrigin(origins = "*")	
@RequestMapping("/farmer-service")
public class FarmerResource {

	@Autowired
	FarmerService farmerService;
	
	@Autowired
	FarmerRepository farmerRepo;
	
	
	  @Autowired 
	  RestTemplate restTemplate;
	  
	 
	  
	 
	 
	
	
	
	//display farmers added crops
//	@RequestMapping("/{femail}/fetchcrops")
//	public List<Crops> findCrops(@PathVariable("femail") String femail)
//	{
//		return farmerService.findCrops(femail);
//	}
//	
	//search crops (soon to be deployed with name)
//	@RequestMapping("/{fid}/search/{cropid}")
//	public Crops searchCrops(@PathVariable("fid") String fid, @PathVariable("cropid") int cropid)
//	{
//		return farmerService.fetchCrop(fid, cropid);
//	}
	
	//ADDING
	
	@RequestMapping(method = RequestMethod.POST, value = "/addFarmer")
	public String addFarmer( @RequestBody Farmer farmer)
	{
		System.out.println("hello farmer add request");
		return farmerService.addFarmer(farmer);
	}
	//add crops for farmers
	@RequestMapping(method = RequestMethod.POST, value = "/addcrops/{farmerEmail}")
	public ResponseEntity<String> addCrops(@PathVariable String farmerEmail, @RequestBody Crops crop)
	{
		System.out.println("addCrop");
		System.out.println(crop.getCropName());
		System.out.println(farmerEmail);
		return farmerService.addCrops(farmerEmail, crop);
	}
	
	
	
	@GetMapping("/fetchCropsFarmerEmail/{farmerEmail}")
	public List<Crops> findCrops(@PathVariable("farmerEmail") String farmerEmail)
	{
//		System.out.println(farmerEmail+"hello");
		return farmerService.fetchCropsFarmerEmail(farmerEmail);
	}
	@GetMapping("/fetchCropsFarmerEmailCropName/{farmerEmail}/{cropName}")
	public Crops fetchCropsFarmerEmailCropName(@PathVariable("farmerEmail") String farmerEmail,@PathVariable String  cropName)
	{
//		System.out.println(farmerEmail+cropName+"hello");
		return farmerService.fetchCropsFarmerEmailCropName(farmerEmail,cropName);
	}
	
	@PutMapping("/updateCropInc/{farmerEmail}/{cropName}/{qty}")
	public void updateCropInc(@PathVariable("farmerEmail") String farmerEmail,@PathVariable String  cropName ,@PathVariable int qty)
	{
//		System.out.println(farmerEmail+cropName+"hello");
		farmerService.updateCropInc(farmerEmail,cropName,qty);
		return;
	}
	
	@PutMapping("/updateCropDec/{farmerEmail}/{cropName}/{qty}")
	public void updateCropDec(@PathVariable("farmerEmail") String farmerEmail,@PathVariable String  cropName ,@PathVariable int qty)
	{
//		System.out.println(farmerEmail+cropName+"hello");
		farmerService.updateCropDec(farmerEmail,cropName,qty);
		return;
	}
	
	@DeleteMapping("/deleteCrop/{farmerEmail}/{cropName}")
	public void deleteCrop(@PathVariable("farmerEmail") String farmerEmail,@PathVariable String  cropName)
	{
		System.out.println(farmerEmail+cropName+"hello");
		farmerService.deleteCrop(farmerEmail,cropName);
		return;
	}
	
	
	//UPDATION
	
	//update farmer details
//	@RequestMapping(method = RequestMethod.PUT, value = "/update/{fid}")
//	public String updateDetails(@RequestBody Farmer farmer, @PathVariable("fid") String fid)
//	{
//		return farmerService.updateFarmer(farmer, fid);
//	}
	
	//update crops for farmers
//	@RequestMapping(method = RequestMethod.PUT, value = "/{fid}/updateCrops/{cropid}")
//	public String updateCrops(@PathVariable("fid") String fid, @PathVariable("cropid") int cropid, @RequestBody Crops crop)
//	{
//		return farmerService.updateCrop(fid, cropid,} crop);
//	}
	
	//DELETION
	
	//let farmer delete its account
//	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{fid}")
//	public String deleteFarmer(@PathVariable("fid") String fid)
//	{
//		return farmerService.deleteFarmer(fid);
//	}
	
	//let farmer delete the crop that he has added
//	@RequestMapping(method = RequestMethod.DELETE, value = "/{fid}/delete/{cropid}")
//	public String deleteCrop(@PathVariable("fid") String fid, @PathVariable("cropid") int cropid)
//	{
//		return farmerService.deleteCrop(fid, cropid);
//	}
//	
//	//farmer email fetch
//		@GetMapping("/farmer/{femail}")
//		public List<Farmer> dealerEmailFetch(@PathVariable("femail") String femail)
//		{
//			return farmerService.getFarmerDetailsbyEmail(femail);
//		}

}
