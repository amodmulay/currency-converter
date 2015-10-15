package com.avm.zoocode.service.dto.currency;

import java.util.Date;
import java.util.Map;

public class ExchangeRateDto {

	private String base;

	private Date date;

	private Map<String, Object> rates;

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

	public Map<String, Object> getRates() {
		return rates;
	}

	public void setRates(Map<String, Object> rates) {
		this.rates = rates;
	}

}
