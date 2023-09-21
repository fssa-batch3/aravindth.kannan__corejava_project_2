package com.fssa.sharpandclean.model;

public class SalonBook {

	private int bookId;
	private String bookUserName;
	private String bookUserPhone;
	private String bookService;
	private String bookDate;
	private String bookTime;
	private String booUserEmail;
	private String salonName;
	private String salonEmail;
	private String salonPhone;
	private String salonProfile;
	private String salonEx;
	private String salonAddress;
	private String salonAbout;
	private String salonArea;
	private int bookSalonIsDeleted;
	private int bookUserIsDeleted;
	
	

	public SalonBook(String bookUserName, String bookUserPhone, String bookService, String bookDate, String bookTime,
			String booUserEmail, String salonName, String salonEmail, String salonPhone, String salonProfile,
			String salonEx, String salonAddress, String salonAbout, String salonArea) {
		super();
		this.bookUserName = bookUserName;
		this.bookUserPhone = bookUserPhone;
		this.bookService = bookService;
		this.bookDate = bookDate;
		this.bookTime = bookTime;
		this.booUserEmail = booUserEmail;
		this.salonName = salonName;
		this.salonEmail = salonEmail;
		this.salonPhone = salonPhone;
		this.salonProfile = salonProfile;
		this.salonEx = salonEx;
		this.salonAddress = salonAddress;
		this.salonAbout = salonAbout;
		this.salonArea = salonArea;
	}
	
	public SalonBook() {
		super();
	}

	public String getBookUserPhone() {
		return bookUserPhone;
	}
	public void setBookUserPhone(String bookUserPhone) {
		this.bookUserPhone = bookUserPhone;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookUserName() {
		return bookUserName;
	}
	public void setBookUserName(String bookUserName) {
		this.bookUserName = bookUserName;
	}
	public String getBookService() {
		return bookService;
	}
	public void setBookService(String bookService) {
		this.bookService = bookService;
	}
	public String getBookDate() {
		return bookDate;
	}
	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}
	public String getBookTime() {
		return bookTime;
	}
	public void setBookTime(String bookTime) {
		this.bookTime = bookTime;
	}
	public String getBooUserEmail() {
		return booUserEmail;
	}
	public void setBooUserEmail(String booUserEmail) {
		this.booUserEmail = booUserEmail;
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
	public String getSalonProfile() {
		return salonProfile;
	}
	public void setSalonProfile(String salonProfile) {
		this.salonProfile = salonProfile;
	}
	public String getSalonEx() {
		return salonEx;
	}
	public void setSalonEx(String salonEx) {
		this.salonEx = salonEx;
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
	public String getSalonArea() {
		return salonArea;
	}
	public void setSalonArea(String salonArea) {
		this.salonArea = salonArea;
	}
	public int getBookSalonIsDeleted() {
		return bookSalonIsDeleted;
	}
	public void setBookSalonIsDeleted(int bookSalonIsDeleted) {
		this.bookSalonIsDeleted = bookSalonIsDeleted;
	}
	public int getBookUserIsDeleted() {
		return bookUserIsDeleted;
	}
	public void setBookUserIsDeleted(int bookUserIsDeleted) {
		this.bookUserIsDeleted = bookUserIsDeleted;
	}
	

	@Override
	public String toString() {
		return "SalonBook [bookId=" + bookId + ", bookUserName=" + bookUserName + ", bookUserPhone=" + bookUserPhone
				+ ", bookService=" + bookService + ", bookDate=" + bookDate + ", bookTime=" + bookTime
				+ ", booUserEmail=" + booUserEmail + ", salonName=" + salonName + ", salonEmail=" + salonEmail
				+ ", salonPhone=" + salonPhone + ", salonProfile=" + salonProfile + ", salonEx=" + salonEx
				+ ", salonAddress=" + salonAddress + ", salonAbout=" + salonAbout + ", salonArea=" + salonArea
				+ ", bookSalonIsDeleted=" + bookSalonIsDeleted + ", bookUserIsDeleted=" + bookUserIsDeleted
				+ ", getBookUserPhone()=" + getBookUserPhone() + ", getBookId()=" + getBookId() + ", getBookUserName()="
				+ getBookUserName() + ", getBookService()=" + getBookService() + ", getBookDate()=" + getBookDate()
				+ ", getBookTime()=" + getBookTime() + ", getBooUserEmail()=" + getBooUserEmail() + ", getSalonName()="
				+ getSalonName() + ", getSalonEmail()=" + getSalonEmail() + ", getSalonPhone()=" + getSalonPhone()
				+ ", getSalonProfile()=" + getSalonProfile() + ", getSalonEx()=" + getSalonEx() + ", getSalonAddress()="
				+ getSalonAddress() + ", getSalonAbout()=" + getSalonAbout() + ", getSalonArea()=" + getSalonArea()
				+ ", getBookSalonIsDeleted()=" + getBookSalonIsDeleted() + ", getBookUserIsDeleted()="
				+ getBookUserIsDeleted() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
