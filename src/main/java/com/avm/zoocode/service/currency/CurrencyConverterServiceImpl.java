package com.avm.zoocode.service.currency;

import org.springframework.beans.factory.annotation.Autowired;

import com.avm.zoocode.service.dto.currency.ExchangeRateDto;
import com.avm.zoocode.service.dto.currency.ExchangeRequestDto;
import com.avm.zoocode.webservice.rest.FixerECBRateConsumer;
import com.avm.zoocode.webservice.rest.json.ExchangeRate;

public class CurrencyConverterServiceImpl implements CurrencyConverterService {

	@Autowired
	FixerECBRateConsumer fixerECBRateConsumer;
	@Override
	public ExchangeRateDto getAllCurrencyRates() {
		ExchangeRate rates = fixerECBRateConsumer.getAllExchangeRates();
		ExchangeRateDto rateDto = new ExchangeRateDto();
		rateDto.setBase(rates.getBase());
		rateDto.setDate(rates.getDate());
		rateDto.setRates(rates.getRates());
		return rateDto;
	}

	@Override
	public ExchangeRequestDto getExchangeRate(String fromCurrency, String toCurrency) {
		// TODO Auto-generated method stub
		return null;
	}

}
