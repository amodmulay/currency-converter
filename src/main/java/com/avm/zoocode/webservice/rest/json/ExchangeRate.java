package com.avm.zoocode.webservice.rest.json;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRate {

	private String base;

	private Date date;

	private Map<String, Float> rates;

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Map<String, Float> getRates() {
		return rates;
	}

	public void setRates(Map<String, Float> rates) {
		this.rates = rates;
	}

	@Override
	public String toString() {
		return "ExchangeRate [base=" + base + ", date=" + date + ", rates=" + rates + "]";
	}

	
}
