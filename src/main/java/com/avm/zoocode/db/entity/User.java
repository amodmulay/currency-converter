package com.avm.zoocode.db.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "password_hash", nullable = false)
	private String passwordHash;
	
	@Column(name="birth_date", nullable = false)
	private Date date;
	
	@Column(name="street", nullable =  false)
	private String street;
	
	@Column(name="zip_code", nullable =  false)
	private String zipCode;
	
	@Column(name="city", nullable =  false)
	private String city;
	
	@Column(name="country", nullable =  false)
	private String country;
	
	
	
	@OneToMany
	@JoinColumn(name = "user_id")
	@Size(max=10)
	private Set<ActivityLog> activityLogs;

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

//	public String getRole() {
//		return "USER";
//	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public Set<ActivityLog> getActivityLogs() {
		return activityLogs;
	}

	public void setActivityLogs(Set<ActivityLog> activityLogs) {
		this.activityLogs = activityLogs;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", email='" + email.replaceFirst("@.*", "@***") + ", passwordHash='"
				+ passwordHash.substring(0, 10) + ", role=USER" + '}';
	}

}
