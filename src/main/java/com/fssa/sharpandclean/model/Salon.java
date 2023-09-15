package com.fssa.sharpandclean.model;

public class Salon {
	
	private String salonName;
	private String salonEmail;
	private String salonPhone;
	private String salonAddress;
	private String salonAbout;
	private String salonURL;
	private String salonArea;
	private String salonExperience;
	private int salonId;
	private String salonSample1;
	private String salonSample2;
	private String salonSample3;
	private int isDeleted;
	
	
	public Salon(String salonName, String salonEmail, String salonPhone, String salonAddress, String salonAbout,
			String salonURL, String salonArea, String salonExperience, String salonSample1, String salonSample2,
			String salonSample3) {
		super();
		this.salonName = salonName;
		this.salonEmail = salonEmail;
		this.salonPhone = salonPhone;
		this.salonAddress = salonAddress;
		this.salonAbout = salonAbout;
		this.salonURL = salonURL;
		this.salonArea = salonArea;
		this.salonExperience = salonExperience;
		this.salonSample1 = salonSample1;
		this.salonSample2 = salonSample2;
		this.salonSample3 = salonSample3;
		
	}
	public Salon(int salonId2, String salonName2, String salonEmail2, String salonProfile, String shopPhone,
			String shopAddress, String salonAbout2, String salonExperience2, String salonArea2, String haircut1,
			String haircut2, String haircut3) {
		super();
		this.salonId = salonId2;
		this.salonName = salonName2;
		this.salonEmail = salonEmail2;
		this.salonPhone = shopPhone;
		this.salonAddress = shopAddress;
		this.salonAbout = salonAbout2;
		this.salonURL = salonProfile;
		this.salonArea = salonArea2;
		this.salonExperience = salonExperience2;
		this.salonSample1 = haircut1;
		this.salonSample2 = haircut2;
		this.salonSample3 = haircut3;
	}
	public String getSalonName() {
		return salonName;
	}
	public void setSalonName(String salonName) {
		this.salonName = salonName;
	}
	public String getSalonEmail() {
		return salonEmail;
	}
	public void setSalonEmail(String salonEmail) {
		this.salonEmail = salonEmail;
	}
	public String getSalonPhone() {
		return salonPhone;
	}
	public void setSalonPhone(String salonPhone) {
		this.salonPhone = salonPhone;
	}
	public String getSalonAddress() {
		return salonAddress;
	}
	public void setSalonAddress(String salonAddress) {
		this.salonAddress = salonAddress;
	}
	public String getSalonAbout() {
		return salonAbout;
	}
	public void setSalonAbout(String salonAbout) {
		this.salonAbout = salonAbout;
	}
	public String getSalonURL() {
		return salonURL;
	}
	public void setSalonURL(String salonURL) {
		this.salonURL = salonURL;
	}
	public String getSalonArea() {
		return salonArea;
	}
	public void setSalonArea(String salonArea) {
		this.salonArea = salonArea;
	}
	public String getSalonExperience() {
		return salonExperience;
	}
	public void setSalonExperience(String salonExperience) {
		this.salonExperience = salonExperience;
	}
	public int getSalonId() {
		return salonId;
	}
	public void setSalonId(int salonId) {
		this.salonId = salonId;
	}
	public String getSalonSample1() {
		return salonSample1;
	}
	public void setSalonSample1(String salonSample1) {
		this.salonSample1 = salonSample1;
	}
	public String getSalonSample2() {
		return salonSample2;
	}
	public void setSalonSample2(String salonSample2) {
		this.salonSample2 = salonSample2;
	}
	public String getSalonSample3() {
		return salonSample3;
	}
	public void setSalonSample3(String salonSample3) {
		this.salonSample3 = salonSample3;
	}
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	@Override
	public String toString() {
		return "Salon [salonName=" + salonName + ", salonEmail=" + salonEmail + ", salonPhone=" + salonPhone
				+ ", salonAddress=" + salonAddress + ", salonAbout=" + salonAbout + ", salonURL=" + salonURL
				+ ", salonArea=" + salonArea + ", salonExperience=" + salonExperience + ", salonId=" + salonId
				+ ", salonSample1=" + salonSample1 + ", salonSample2=" + salonSample2 + ", salonSample3=" + salonSample3
				+ ", isDeleted=" + isDeleted + "]";
	}
}
