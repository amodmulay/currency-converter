package com.avm.zoocode.db.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "activity_log")
public class ActivityLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;

	@Column(name = "user_id", nullable = false)
	private Long userId;
	
	@Column(name = "from_currency", nullable = false)
	private String fromCurrency;
	
	@Column(name = "to_currency", nullable = false)
	private String toCurrency;
	
	@Column(name = "conversion_rate", nullable = false)
	private Float conversionRate;

	@Column(name = "coversion_value", nullable = false)
	private Float coversionValue;
	
	@Column(name = "converted_value", nullable = false)
	private Float convertedValue;
	
	@Column(name = "query_date", nullable = false)
	private Date queryDate;
	
	public Float getConvertedValue() {
		return convertedValue;
	}

	public void setConvertedValue(Float convertedValue) {
		this.convertedValue = convertedValue;
	}

	public Date getQueryDate() {
		return queryDate;
	}

	public void setQueryDate(Date queryDate) {
		this.queryDate = queryDate;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	public Float getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(Float conversionRate) {
		this.conversionRate = conversionRate;
	}

	public Float getCoversionValue() {
		return coversionValue;
	}

	public void setCoversionValue(Float coversionValue) {
		this.coversionValue = coversionValue;
	}

	@Override
	public String toString() {
		return "ActivityLog [id=" + id + ", userId=" + userId + ", fromCurrency=" + fromCurrency + ", toCurrency="
				+ toCurrency + ", conversionRate=" + conversionRate + ", coversionValue=" + coversionValue + "]";
	}
}
