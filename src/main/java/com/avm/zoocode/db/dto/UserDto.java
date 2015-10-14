package com.avm.zoocode.db.dto;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class UserDto {
	@NotEmpty
	private String email="";

	@NotEmpty
	private String password;

	@NotEmpty
	private String passwordRepeated;

	@NotEmpty
	private Date birthDate;

	@NotEmpty
	private String street;

	@NotEmpty
	private String zipCode;

	@NotEmpty
	private String city;

	@NotEmpty
	private String country;

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

	public void setDate(Date birthDate) {
		this.birthDate = birthDate;
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
	

}
