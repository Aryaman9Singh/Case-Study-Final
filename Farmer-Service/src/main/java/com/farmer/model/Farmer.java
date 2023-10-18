package com.farmer.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;




@Document(collection="Farmers")
public class Farmer {
	
	@Id
	private String farmerId;
	@Field
	private String farmerEmail;
	@Field
	private String farmerPassword;
	@Field
	private String farmerName;
	
	@Field
	private String farmerBank;
	@Field
	private String farmerPaytmId;
	@Field
	private String farmerAccountNo;
	@Field
	private String farmerBankBranch;
	@Field
	private String farmerContact;
	@Field
	private String farmerLocation;
	@Field
	private String farmerAbout;
	@Field
	private List<Crops> crops;
	
	public String getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(String farmerId) {
		this.farmerId = farmerId;
	}

	public String getFarmerEmail() {
		return farmerEmail;
	}

	public void setFarmerEmail(String farmerEmail) {
		this.farmerEmail = farmerEmail;
	}

	public String getFarmerPassword() {
		return farmerPassword;
	}

	public void setFarmerPassword(String farmerPassword) {
		this.farmerPassword = farmerPassword;
	}

	public String getFarmerName() {
		return farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}

	public String getFarmerBank() {
		return farmerBank;
	}

	public void setFarmerBank(String farmerBank) {
		this.farmerBank = farmerBank;
	}

	public String getFarmerPaytmId() {
		return farmerPaytmId;
	}

	public void setFarmerPaytmId(String farmerPaytmId) {
		this.farmerPaytmId = farmerPaytmId;
	}

	public String getFarmerAccountNo() {
		return farmerAccountNo;
	}

	public void setFarmerAccountNo(String farmerAccountNo) {
		this.farmerAccountNo = farmerAccountNo;
	}

	public String getFarmerBankBranch() {
		return farmerBankBranch;
	}

	public void setFarmerBankBranch(String farmerBankBranch) {
		this.farmerBankBranch = farmerBankBranch;
	}

	public String getFarmerContact() {
		return farmerContact;
	}

	public void setFarmerContact(String farmerContact) {
		this.farmerContact = farmerContact;
	}

	public String getFarmerLocation() {
		return farmerLocation;
	}

	public void setFarmerLocation(String farmerLocation) {
		this.farmerLocation = farmerLocation;
	}

	public String getFarmerAbout() {
		return farmerAbout;
	}

	public void setFarmerAbout(String farmerAbout) {
		this.farmerAbout = farmerAbout;
	}

	public List<Crops> getCrops() {
		return crops;
	}
	public void setCrops(List<Crops> crops) {
		this.crops = crops;
	}
	
}
