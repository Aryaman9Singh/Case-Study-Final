package com.farmer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.farmer.exception.CropsNullException;
import com.farmer.model.Crops;
import com.farmer.model.Farmer;
import com.farmer.model.FarmerList;
import com.farmer.repository.FarmerRepository;

@Service
public class FarmerService {
	
	//Getting the repository functionality (MongoDB)
	@Autowired
	FarmerRepository farmerRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private SequenceGeneratorService service;
	
	//public FarmerService(FarmerService farmerService) {
		//this.farmerService = farmerService;
	//}
	
	//FETCH CROPS FROM ALL FARMERS
	
//	public FarmerList getAllCrops()
//	{
//		List<Farmer> allCrops = farmerRepo.findAll();
//		FarmerList listfarm = new FarmerList();
//		listfarm.setFarmerlist(allCrops);
//		
//		//return
//		return listfarm;
//	}
//	
//	//FARMER OPERATIONS
//	
//	//add a farmer
	public String addFarmer(Farmer f)
	{
		f.setCrops(null);
		System.out.println("helo farmer service");
//		f.setFabout(null);
		farmerRepo.save(f);
		return "Added Farmer";
	}
//	
//	//get farmer details
//	public Optional<Farmer> getFarmerDetails(String fid)
//	{
//		return farmerRepo.findById(fid);
//	}
//	
//	//update farmer details
//	public String updateFarmer(Farmer f, String fid)
//	{
//		farmerRepo.save(f);
//		//message
//		String success = "Updated Farmer Details";
//		return success+" "+fid;
//	}
//	
//	//delete the farmer
//	public String deleteFarmer(String fid)
//	{
//		farmerRepo.deleteById(fid);
//		String message = "Deleted";
//		return message;
//	}
//	
	//CROP OPERATIONS
	
	//fetch crops for farmers
	public List<Crops> fetchCropsFarmerEmail(String farmerEmail)
	{
//		System.out.println("hello from farmer service "+farmerEmail);
		List<Crops> crops = restTemplate.getForObject("http://localhost:8090/crop-service/getCropsEmail/{farmerEmail}", List.class,farmerEmail);
		return crops;
		
		
	}
	
	public Crops fetchCropsFarmerEmailCropName(String farmerEmail,String cropName)
	{
//		System.out.println("hello from farmer service "+farmerEmail+cropName);
		Crops crop = restTemplate.getForObject("http://crop-service/crop-service/getCropsEmailCropName/{farmerEmail}/{cropName}", 
				Crops.class,
				farmerEmail,
				cropName);
		
		return crop;
		
		
	}
	
	public void updateCropInc(String farmerEamil, String cropName, int qty) {
		
		Farmer farmer = farmerRepo.findByFarmerEmail(farmerEamil);
//		System.out.println(qty +"quantity");
		List<Crops> crops = farmer.getCrops();
		int i = 0;
		for (Crops crop : crops) {
			if(crop.getCropName().equalsIgnoreCase(cropName)) {
				int quantity=Integer.parseInt(crop.getCropqnty()) + qty;
//				System.out.println(quantity+ "after add");
				crops.remove(i);
				
				crop.setCropqnty(String.valueOf(quantity));
//				System.out.println(crop.getCropqnty());
				crops.add(i, crop);
				break;
			}
			i++;
		}
		farmer.setCrops(crops);
		farmerRepo.save(farmer);
	
		String baseUrl= "http://crop-service/crop-service/updateCropInc/"+farmerEamil+"/"+cropName+"/"+qty;
		restTemplate.put(baseUrl, String.class);
	}
	
	
	public void updateCropDec(String farmerEamil, String cropName, int qty) {
		
		Farmer farmer = farmerRepo.findByFarmerEmail(farmerEamil);
//		System.out.println(qty +"quantity");
		List<Crops> crops = farmer.getCrops();
		int i = 0;
		for (Crops crop : crops) {
			if(crop.getCropName().equalsIgnoreCase(cropName)) {
				int quantity=Integer.parseInt(crop.getCropqnty()) - qty;
//				System.out.println(quantity+ "after add");
				crops.remove(i);
				
				crop.setCropqnty(String.valueOf(quantity));
//				System.out.println(crop.getCropqnty());
				crops.add(i, crop);
				break;
			}
			i++;
		}
		farmer.setCrops(crops);
		farmerRepo.save(farmer);
	
		String baseUrl= "http://crop-service/crop-service/updateCropDec/"+farmerEamil+"/"+cropName+"/"+qty;
		restTemplate.put(baseUrl, String.class);
	}
	
	
	
	public void deleteCrop(String farmerEamil, String cropName) {
		Farmer farmer = farmerRepo.findByFarmerEmail(farmerEamil);
//		System.out.println(qty +"quantity");
		System.out.println(farmer.getFarmerName());
		List<Crops> crops = farmer.getCrops();
		System.err.println(crops.isEmpty());
		int i = 0;
		for (Crops crop : crops) {
			if(crop.getCropName().equalsIgnoreCase(cropName)) {
				System.out.println("ïnLoop");
				break;
			}
			i++;
			
		}
		crops.remove(i);
		farmer.setCrops(crops);
		farmerRepo.save(farmer);
		
		String baseUrl= "http://crop-service/crop-service/deleteCrop/"+farmerEamil+"/"+cropName;
		restTemplate.delete(baseUrl);
	}
	
	//Add crops by farmers
	public ResponseEntity<String> addCrops(String farmerEmail, Crops crop)
	{
		Farmer farmer =farmerRepo.findByFarmerEmail(farmerEmail);
		
		System.out.println(farmer.getFarmerName());
		List<Crops> crops = new ArrayList<>();
//		try {
		crops=farmer.getCrops();	
		crops.add(crop);
//		}catch(Exception e) {
//			e.getMessage();
//			
//		}
		System.out.println(crops.get(0).getCropName());
		farmer.setCrops(crops);
		farmerRepo.save(farmer);
		crop.setFarmerId(farmer.getFarmerId());
		System.out.println(crop.getCropName());
		crop.setFarmerEmail(farmerEmail);
		
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Crops> request = new HttpEntity<>(crop, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(
        		"http://localhost:8090/crop-service/addCrop",
            request,
            String.class
        );

        // Handle the response as needed
        return response;
	}
	
	//find all crops added by the farmer
	public List<Crops> findCrops(String farmerEmail)
	{
//		Crops crops = restTemplate.getForObject("http://Crop-Service/addCrop", Crops.class);
		Farmer farmer = farmerRepo.findByFarmerEmail(farmerEmail);
		ResponseEntity<Crops[]> response =
				  restTemplate.getForEntity(
				  "http://localhost:8090/crop-service/getCropsEmail/{farmerEmail}",
				  Crops[].class);

		return null;
		//search functionality yet to be deployed
	}
	
	//update the crop for the farmer
	public String updateCrop(String fid, int cropid, Crops crop)
	{
		return null;
	}
	
	//delete crops added by farmer
	public String deleteCrop(String fid,int cropid)
	{
		return null;
	}
	

}




