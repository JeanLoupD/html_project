package com.model;

public class Store {
	private String name;
	private String address;
	private String phone;
	private String areas;
	
	private String sundayOpen;
	private String sundayClose;
	private String mondayOpen;
	private String mondayClose;
	private String tuesdayOpen;
	private String tuesdayClose;
	private String wednesdayOpen;
	private String wednesdayClose;
	private String thursdayOpen;
	private String thursdayClose;
	private String fridayOpen;
	private String fridayClose;
	private String saturdayOpen;
	private String saturdayClose;
	
	private String status;
	
	//Empty Constructor
	public Store() {};
	
	//Constructor
	public Store(String name,
			     String address,
			     String phone,
			     String areas,
			     String sundayOpen,
			     String sundayClose,
			     String mondayOpen,
			     String mondayClose,
			     String tuesdayOpen,
			     String tuesdayClose,
			     String wednesdayOpen,
			     String wednesdayClose,
			     String thursdayOpen,
			     String thursdayClose,
			     String fridayOpen,
			     String fridayClose,
			     String saturdayOpen,
			     String saturdayClose,
			     String status) {
		
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.areas = areas;
		this.sundayOpen = sundayOpen;
		this.sundayClose = sundayClose;
		this.mondayOpen = mondayOpen;
		this.mondayClose = mondayClose;
		this.tuesdayOpen = tuesdayOpen;
		this.tuesdayClose = tuesdayClose;
		this.wednesdayOpen = wednesdayOpen;
		this.wednesdayClose = wednesdayClose;
		this.thursdayOpen = thursdayOpen;
		this.thursdayClose = thursdayClose;
		this.fridayOpen = fridayOpen;
		this.fridayClose = fridayClose;
		this.saturdayOpen = saturdayOpen;
		this.saturdayClose = saturdayClose;
		this.status = status;
		
	}

	/*
	 * Getters and Setters
	 * */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSundayOpen() {
		return sundayOpen;
	}

	public void setSundayOpen(String sundayOpen) {
		this.sundayOpen = sundayOpen;
	}

	public String getSundayClose() {
		return sundayClose;
	}

	public void setSundayClose(String sundayClose) {
		this.sundayClose = sundayClose;
	}

	public String getMondayOpen() {
		return mondayOpen;
	}

	public void setMondayOpen(String mondayOpen) {
		this.mondayOpen = mondayOpen;
	}

	public String getMondayClose() {
		return mondayClose;
	}

	public void setMondayClose(String mondayClose) {
		this.mondayClose = mondayClose;
	}

	public String getTuesdayOpen() {
		return tuesdayOpen;
	}

	public void setTuesdayOpen(String tuesdayOpen) {
		this.tuesdayOpen = tuesdayOpen;
	}

	public String getTuesdayClose() {
		return tuesdayClose;
	}

	public void setTuesdayClose(String tuesdayClose) {
		this.tuesdayClose = tuesdayClose;
	}

	public String getWednesdayOpen() {
		return wednesdayOpen;
	}

	public void setWednesdayOpen(String wednesdayOpen) {
		this.wednesdayOpen = wednesdayOpen;
	}

	public String getWednesdayClose() {
		return wednesdayClose;
	}

	public void setWednesdayClose(String wednesdayClose) {
		this.wednesdayClose = wednesdayClose;
	}

	public String getThursdayOpen() {
		return thursdayOpen;
	}

	public void setThursdayOpen(String thursdayOpen) {
		this.thursdayOpen = thursdayOpen;
	}

	public String getThursdayClose() {
		return thursdayClose;
	}

	public void setThursdayClose(String thursdayClose) {
		this.thursdayClose = thursdayClose;
	}

	public String getFridayOpen() {
		return fridayOpen;
	}

	public void setFridayOpen(String fridayOpen) {
		this.fridayOpen = fridayOpen;
	}

	public String getFridayClose() {
		return fridayClose;
	}

	public void setFridayClose(String fridayClose) {
		this.fridayClose = fridayClose;
	}

	public String getSaturdayOpen() {
		return saturdayOpen;
	}

	public void setSaturdayOpen(String saturdayOpen) {
		this.saturdayOpen = saturdayOpen;
	}

	public String getSaturdayClose() {
		return saturdayClose;
	}

	public void setSaturdayClose(String saturdayClose) {
		this.saturdayClose = saturdayClose;
	}

	public String getAreas() {
		return areas;
	}

	public void setAreas(String areas) {
		this.areas = areas;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
