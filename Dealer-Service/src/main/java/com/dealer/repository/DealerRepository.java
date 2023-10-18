package com.dealer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dealer.model.Dealer;

@Repository
public interface DealerRepository extends MongoRepository<Dealer, String>{
	
	Dealer findByDealerEmail(String dealeremail);

}
