package com.avm.zoocode.service.currency;

import java.util.Date;
import java.util.Map;

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
	public ExchangeRequestDto getExchangeRate(final String fromCurrency, final String toCurrency,
			final Float changeValue) {

		ExchangeRate exchangeRate = fixerECBRateConsumer.getExchangeRate(fromCurrency, toCurrency);
		Date date = exchangeRate.getDate();
		Map<String, Float> rates = exchangeRate.getRates();

		Float value = rates.get(toCurrency) * changeValue;

		ExchangeRequestDto exchangeDto = new ExchangeRequestDto();
		exchangeDto.setRateDate(date);
		exchangeDto.setChangeValue(changeValue);
		exchangeDto.setCovertedValue(value);
		exchangeDto.setExchangeRate(rates.get(toCurrency));
		exchangeDto.setFromCurreny(fromCurrency);
		exchangeDto.setToCurrency(toCurrency);

		return null;
	}

}
