package com.avm.zoocode.service.currency;

import com.avm.zoocode.webservice.rest.json.ExchangeRate;

public interface CurrencyConverterService {
	
	public ExchangeRate getAllCurrencyRates();
} 
