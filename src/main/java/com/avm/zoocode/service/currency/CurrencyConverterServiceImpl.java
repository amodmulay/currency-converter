package com.avm.zoocode.service.currency;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.avm.zoocode.db.entity.ActivityLog;
import com.avm.zoocode.db.repository.ActivityLogRepository;
import com.avm.zoocode.db.repository.UserRepository;
import com.avm.zoocode.service.dto.currency.ExchangeRateDto;
import com.avm.zoocode.service.dto.currency.ExchangeRequestDto;
import com.avm.zoocode.websconsumer.rest.FixerECBRateConsumer;
import com.avm.zoocode.webservice.rest.json.ExchangeRate;

@Service
public class CurrencyConverterServiceImpl implements CurrencyConverterService {

	@Autowired
	private FixerECBRateConsumer fixerECBRateConsumer;

	@Autowired
	private ActivityLogRepository activityLogRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public ExchangeRateDto getAllCurrencyRates() {
		ExchangeRate rates = fixerECBRateConsumer.getAllExchangeRates();
		ExchangeRateDto rateDto = new ExchangeRateDto();
		rateDto.setBase(rates.getBase());
		rateDto.setDate(rates.getDate());
		rateDto.setRates(rates.getRates());
		rateDto.getRates().put("EUR", 1f);
		return rateDto;
	}

	@Override
	public ExchangeRequestDto getConvertedValue(final String fromCurrency, final String toCurrency,
			final Float valueToConvert) {

		ExchangeRate exchangeRate = fixerECBRateConsumer.getExchangeRate(fromCurrency, toCurrency);

		return calculate(exchangeRate, fromCurrency, toCurrency, valueToConvert);
	}

	@Override
	public ExchangeRequestDto getHistoricalConvertedValue(final String fromCurrency, final String toCurrency,
			final Float valueToConvert, final Date date) {
		ExchangeRate exchangeRate = fixerECBRateConsumer.getHistoricalValue(fromCurrency, toCurrency, date);
		return calculate(exchangeRate, fromCurrency, toCurrency, valueToConvert);
	}

	private ExchangeRequestDto calculate(final ExchangeRate exchangeRate, final String fromCurrency,
			final String toCurrency, final Float valueToConvert) {

		Date date = exchangeRate.getDate();
		Map<String, Float> rates = exchangeRate.getRates();

		if (rates.isEmpty()) {
			rates.put(toCurrency, 1f); // used only when both currencies that
										// are selected are same
		}

		Float value = rates.get(toCurrency) * valueToConvert;

		ExchangeRequestDto exchangeDto = new ExchangeRequestDto();
		exchangeDto.setRateDate(date);
		exchangeDto.setValueToConvert(valueToConvert);
		exchangeDto.setCovertedValue(value);
		exchangeDto.setExchangeRate(rates.get(toCurrency));
		exchangeDto.setFromCurreny(fromCurrency);
		exchangeDto.setToCurrency(toCurrency);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = auth.getName(); // get logged in username
		ActivityLog activityLog = new ActivityLog();
		activityLog.setUserId(userRepository.findUserByEmail(userEmail).get().getId());
		activityLog.setFromCurrency(fromCurrency);
		activityLog.setToCurrency(toCurrency);
		activityLog.setConversionRate(exchangeDto.getExchangeRate());
		activityLog.setCoversionValue(valueToConvert);
		activityLog.setConvertedValue(exchangeDto.getCovertedValue());
		activityLog.setQueryDate(new Date());
		activityLog = activityLogRepository.save(activityLog);

		return exchangeDto;
	}

}
