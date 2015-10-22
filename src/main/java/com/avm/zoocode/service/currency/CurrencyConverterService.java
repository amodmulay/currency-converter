package com.avm.zoocode.service.currency;

import java.util.Date;

import com.avm.zoocode.service.dto.currency.ExchangeRateDto;
import com.avm.zoocode.service.dto.currency.ExchangeRequestDto;

public interface CurrencyConverterService {
	
	public ExchangeRateDto getAllCurrencyRates();
	
	public ExchangeRequestDto getConvertedValue(String fromCurrency, String toCurrency, Float valueToConvert);
	public ExchangeRequestDto getHistoricalConvertedValue(String fromCurrency, String toCurrency, Float valueToConvert, Date date);
} 
