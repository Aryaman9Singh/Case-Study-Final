package com.dealer.model;


import org.springframework.data.mongodb.core.mapping.Document;


@Document("crops")
public class Crops {
	
	
	
	private  String fid;
	private  int cropid;
	private  String cropname;
	private  String cropimage;
	private  String cropqlty;
	private  String cropdesc;
	private  String croplocation;
	private  String cropcontact;
	private  String cropqnty;
	private  String cropprice;
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public int getCropid() {
		return cropid;
	}
	public void setCropid(int cropid) {
		this.cropid = cropid;
	}
	public String getCropname() {
		return cropname;
	}
	public void setCropname(String cropname) {
		this.cropname = cropname;
	}
	public String getCropimage() {
		return cropimage;
	}
	public void setCropimage(String cropimage) {
		this.cropimage = cropimage;
	}
	public String getCropqlty() {
		return cropqlty;
	}
	public void setCropqlty(String cropqlty) {
		this.cropqlty = cropqlty;
	}
	public String getCropdesc() {
		return cropdesc;
	}
	public void setCropdesc(String cropdesc) {
		this.cropdesc = cropdesc;
	}
	public String getCroplocation() {
		return croplocation;
	}
	public void setCroplocation(String croplocation) {
		this.croplocation = croplocation;
	}
	public String getCropcontact() {
		return cropcontact;
	}
	public void setCropcontact(String cropcontact) {
		this.cropcontact = cropcontact;
	}
	public String getCropqnty() {
		return cropqnty;
	}
	public void setCropqnty(String cropqnty) {
		this.cropqnty = cropqnty;
	}
	public String getCropprice() {
		return cropprice;
	}
	public void setCropprice(String cropprice) {
		this.cropprice = cropprice;
	}
	
	
}
