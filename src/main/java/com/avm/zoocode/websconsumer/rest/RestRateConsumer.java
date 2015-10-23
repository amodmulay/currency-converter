package com.avm.zoocode.websconsumer.rest;

public interface RestRateConsumer<T> {
	public T getAllExchangeRates();
	public T getExchangeRate(String fromCurrency, String toCurrency);
}
