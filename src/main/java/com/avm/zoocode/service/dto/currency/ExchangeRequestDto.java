package com.avm.zoocode.service.dto.currency;

import java.util.Date;

public class ExchangeRequestDto {

	private String fromCurreny;

	private String toCurrency;

	private Float exchangeRate;

	private Float valueToConvert;

	private Float covertedValue;

	private Date rateDate;

	public String getFromCurreny() {
		return fromCurreny;
	}

	public void setFromCurreny(String fromCurreny) {
		this.fromCurreny = fromCurreny;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	public Float getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Float exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public Float getCovertedValue() {
		return covertedValue;
	}

	public void setCovertedValue(Float covertedValue) {
		this.covertedValue = covertedValue;
	}

	public Date getRateDate() {
		return rateDate;
	}

	public void setRateDate(Date rateDate) {
		this.rateDate = rateDate;
	}

	public Float getValueToConvert() {
		return valueToConvert;
	}

	public void setValueToConvert(Float valueToConvert) {
		this.valueToConvert = valueToConvert;
	}

}
