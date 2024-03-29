package com.example.springsecurity.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurity.entity.UserInfo;
import com.example.springsecurity.model.AuthRequest;
import com.example.springsecurity.model.Dealer;
import com.example.springsecurity.model.Farmer;
import com.example.springsecurity.repository.DealerRepository;
import com.example.springsecurity.repository.FarmerRepository;

import com.example.springsecurity.repository.UserInfoRepository;
import com.example.springsecurity.service.DealerService;
import com.example.springsecurity.service.FarmerService;
import com.example.springsecurity.service.JwtService;

@RestController
@CrossOrigin(origins = "*")	
@RequestMapping("/auth")
public class Controller {
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private FarmerRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private DealerRepository dealerRepository;
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Autowired
	private FarmerService farmerService;
	
	@Autowired
	private DealerService dealerService;
	
	
	@PostMapping("/registerFarmer")
	public ResponseEntity<?> registerFarmer(@RequestBody Farmer farmer) {
		
//		farmer.setId(Integer.toString((userInfoRepository.findAll().size())+1));
//		repository.save(farmer);
//		System.out.println("hello"+farmer.getFarmerName());
		farmerService.addFarmer("0", farmer);
//		System.out.println(farmer.getFarmerName());
		UserInfo userInfo = new UserInfo();
		userInfo.setId(farmer.getId());
		System.out.println(farmer.getFarmerName());
		userInfo.setName(farmer.getFarmerName());
		System.out.println(farmer.getFarmerPassword());
		userInfo.setPassword(passwordEncoder.encode(farmer.getFarmerPassword()));
		userInfo.setRoles("ROLE_FARMER");
		userInfo.setEmail(farmer.getFarmerEmail());
		userInfoRepository.save(userInfo);
//		AuthRequest authRequest = new AuthRequest(farmer.getFarmerName(),farmer.getPassword());
//		Authentication authentication= authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(
//						authRequest.getUsername(),
//						authRequest.getPassword()));
//		if(authentication.isAuthenticated()) {
////			System.out.println("auth");
//			UserInfo user =  userInfoRepository.findByName(authRequest.getUsername()).get();
//			String token=jwtService.generateToken(user.getName(),user.getRoles());
////		return "added DEALER with id: " + dealer.getId();
//			return ResponseEntity.ok(token);
//		}
//		else
//		{
//			throw new UsernameNotFoundException("invalid username");
//		}
//		return "added FARMER with id: " + farmer.getId();
		return ResponseEntity.ok(farmer.getFarmerAbout());
		
	}
	@PostMapping("/registerDealer")
	public ResponseEntity<?> registerDealer(@RequestBody Dealer dealer) {
//		dealer.setId(Integer.toString((userInfoRepository.findAll().size())+1));
		dealerService.addDealer("0", dealer);
//		dealerRepository.save(dealer);
		UserInfo userInfo = new UserInfo();
//		userInfo.setId(dealer.getId());
		userInfo.setName(dealer.getDealerName());
		userInfo.setPassword(passwordEncoder.encode(dealer.getDealerPassword()));
		userInfo.setRoles("ROLE_DEALER");
		userInfo.setEmail(dealer.getDealerEmail());
		userInfoRepository.save(userInfo);
//		AuthRequest authRequest = new AuthRequest(dealer.getDealerName(),dealer.getDealerPassword());
//		Authentication authentication= authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(
//						authRequest.getUsername(),
//						authRequest.getPassword()));
//		if(authentication.isAuthenticated()) {
////			System.out.println("auth");
//			UserInfo user =  userInfoRepository.findByName(authRequest.getUsername()).get();
//			String token=jwtService.generateToken(user.getName(),user.getRoles());
////		return "added DEALER with id: " + dealer.getId();
//			return ResponseEntity.ok(token);
//		}
//		else
//		{
//			throw new UsernameNotFoundException("invalid username");
//		}
		return ResponseEntity.ok(dealer.getDealerAbout());
		
	}
	
	@GetMapping("/welcome")
	public String welcome(){
		return "welcome";
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
//		System.out.println(authRequest.getUsername()+authRequest.getPassword());
		Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())); 
		if(authentication.isAuthenticated()) {
			System.out.println("auth"+authRequest.getUsername());
			UserInfo user =  userInfoRepository.findByName(authRequest.getUsername()).get();
			String token=jwtService.generateToken(user.getName(),user.getRoles(),user.getEmail());
//			System.out.println(token);
			return ResponseEntity.ok(token);	
		}
		else {
			throw new UsernameNotFoundException("invalid username");
		}
		
	}

}
