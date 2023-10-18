package com.dealer.resource;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dealer.model.Crops;
import com.dealer.model.CropsList;
import com.dealer.model.Dealer;
import com.dealer.model.DealerList;
import com.dealer.repository.DealerRepository;
import com.dealer.services.DealerService;


@RestController

@RequestMapping("/dealer-service")
public class DealerResource {
	
	@Autowired
	DealerService dealerService;
	
	@Autowired
	DealerRepository dealerRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	

	
	
	@PostMapping("/addDealer")
	public String addDealer(@RequestBody Dealer dealer)
	{
		return dealerService.addDealer(dealer);
	}

	
	
	@RequestMapping("/{dealerid}")
	public Optional<Dealer> fetchDealer(@PathVariable("dealerid") String dealerid)
	{
		return dealerService.getDealer(dealerid);
	}
	
	//update Dealer details
	@RequestMapping(method = RequestMethod.PUT, value = "/update/{dealerid}")
	public String updateDetails(@RequestBody Dealer dealer, @PathVariable("dealerid") String dealerid)
	{
		return dealerService.updateDealer(dealer, dealerid);
	}
	
	//delete Dealer Details
	@RequestMapping(method = RequestMethod.DELETE, value="/delete/{dealerid}")
	public String deleteDetails(@PathVariable("dealerid") String dealerid)
	{
		return dealerService.deleteDealer(dealerid);
	}
	
	//view the dealer crops
	@RequestMapping("/dealercrops/{randomid}")
	public Optional<CropsList> fetchDealerCrops(@PathVariable("randomid") String randomid)
	{
		return dealerService.getDealerCrops(randomid);
	}
	
	@RequestMapping("/dcrops/{randomid}")
	public List<Crops> fetchCropsArray(@PathVariable("randomid") String randomid)
	{
		return dealerService.getAllCropsArray(randomid);
	}
	
	//view all crops
	@RequestMapping("/dealerCrops/{randomid}")
	public List<Crops> fetchCrops(@PathVariable("randomid") String randomid)
	{
		return dealerService.getCropsarray(randomid);
	}
	
	@GetMapping("/listfarmers")
	public List<Object> getFarmers() {
	Object[] objects = restTemplate.getForObject("http://cr/listfarmers", Object[].class);
	return Arrays.asList(objects);
	}
//	
//	/*
//	 * //dealer email fetch
//	 * 
//	 * @GetMapping("/dealer/{dealeremail}") public List<Dealer>
//	 * dealerEmailFetch(@PathVariable("dealeremail") String dealeremail) { return
//	 * dealerService.getDealerDetailsbyEmail(dealeremail); }
//	 */

}
