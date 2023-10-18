package com.dealer.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;




@Document("Dealers")
public class Dealer {
	
	@Id
	private String dealerId;
	@Field 	//username
	private String dealerEmail;
	@Field	//password
	private String dealerPassword;
	@Field
	private String dealerName;
	@Field
	private String dealerPhone;
	
	@Field
	private String dealerLocation;
	@Field
	private String dealerAbout;
	@Field
	private String dealerBank;
	@Field
	private String dealerBranch;
	@Field
	private String dealerAccountNo;
	@Field
	private String dealerPaytmId;
	public String getDealerId() {
		return dealerId;
	}
	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}
	public String getDealerEmail() {
		return dealerEmail;
	}
	public void setDealerEmail(String dealerEmail) {
		this.dealerEmail = dealerEmail;
	}
	public String getDealerPassword() {
		return dealerPassword;
	}
	public void setDealerPassword(String dealerPassword) {
		this.dealerPassword = dealerPassword;
	}
	public String getDealerName() {
		return dealerName;
	}
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}
	public String getDealerPhone() {
		return dealerPhone;
	}
	public void setDealerPhone(String dealerPhone) {
		this.dealerPhone = dealerPhone;
	}
	
	public String getDealerLocation() {
		return dealerLocation;
	}
	public void setDealerLocation(String dealerLocation) {
		this.dealerLocation = dealerLocation;
	}
	public String getDealerAbout() {
		return dealerAbout;
	}
	public void setDealerAbout(String dealerAbout) {
		this.dealerAbout = dealerAbout;
	}
	public String getDealerBank() {
		return dealerBank;
	}
	public void setDealerBank(String dealerBank) {
		this.dealerBank = dealerBank;
	}
	public String getDealerBranch() {
		return dealerBranch;
	}
	public void setDealerBranch(String dealerBranch) {
		this.dealerBranch = dealerBranch;
	}
	public String getDealerAccountNo() {
		return dealerAccountNo;
	}
	public void setDealerAccountNo(String dealerAccountNo) {
		this.dealerAccountNo = dealerAccountNo;
	}
	public String getDealerPaytmId() {
		return dealerPaytmId;
	}
	public void setDealerPaytmId(String dealerPaytmId) {
		this.dealerPaytmId = dealerPaytmId;
	}

	
}
