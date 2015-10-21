package com.avm.zoocode.service.dto;


import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.avm.zoocode.db.entity.ActivityLog;

public class UserDto {
	@NotNull
	private String email = "";

	@NotNull
	private String password = "";

	@NotNull
	private String passwordRepeated = "";

	@NotNull
	private Date birthDate = new Date();

	@NotNull
	private String street = "";

	@NotNull
	private String zipCode;

	@NotNull
	private String city;

	@NotNull
	private String country;
	
	private List<ActivityLog> activityLog; //Use DTO here

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRepeated() {
		return passwordRepeated;
	}

	public void setPasswordRepeated(String passwordRepeated) {
		this.passwordRepeated = passwordRepeated;
	}

	public Date getDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<ActivityLog> getActivityLog() {
		return activityLog;
	}

	public void setActivityLog(List<ActivityLog> activityLog) {
		this.activityLog = activityLog;
	}
}
