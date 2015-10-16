package com.avm.zoocode.service.currency;

import com.avm.zoocode.service.dto.currency.ExchangeRateDto;
import com.avm.zoocode.service.dto.currency.ExchangeRequestDto;

public interface CurrencyConverterService {
	
	public ExchangeRateDto getAllCurrencyRates();
	
	public ExchangeRequestDto getExchangeRate(String fromCurrency, String toCurrency, Float changeValue);
} 
