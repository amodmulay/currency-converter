package com.avm.zoocode.service.dto.currency;

public class ExchangeRequestDto {

	private String fromCurreny;

	private String toCurrency;

	private Float exchangeRate;

	private Float exchangeValue;

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

	public Float getExchangeValue() {
		return exchangeValue;
	}

	public void setExchangeValue(Float exchangeValue) {
		this.exchangeValue = exchangeValue;
	}

}
