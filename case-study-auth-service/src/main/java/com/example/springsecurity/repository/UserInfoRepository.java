package com.example.springsecurity.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.springsecurity.entity.UserInfo;

public interface UserInfoRepository extends MongoRepository<UserInfo, String> {

	Optional<UserInfo> findByName(String username);
	 
}
