package com.avm.zoocode.webservice.rest;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.avm.zoocode.webservice.rest.json.ExchangeRate;

@Component
public class FixerECBRateConsumer implements RestRateConsumer<ExchangeRate> {

	public static void main(String args) {
		RestTemplate restTemplate = new RestTemplate();
		ExchangeRate quote = restTemplate.getForObject("http://api.fixer.io/latest?base=EUR&symbols=USD,GBP",
				ExchangeRate.class);
		System.out.println(quote.toString());
	}

	public ExchangeRate getAllExchangeRates() {
		RestTemplate restTemplate = new RestTemplate();
		ExchangeRate rates = restTemplate.getForObject("http://api.fixer.io/latest", ExchangeRate.class);
		return rates;
	}

	public ExchangeRate getExchangeRate(final String fromCurrency, final String toCurrency) {
		RestTemplate restTemplate = new RestTemplate();
		ExchangeRate rates = restTemplate.getForObject(
				"http://api.fixer.io/latest?base=" + fromCurrency + "&symbols=" + fromCurrency + "," + toCurrency,
				ExchangeRate.class);
		return rates;
	}

	public ExchangeRate getHistoricalValue(final String fromCurrency, final String toCurrency, final Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String historicalDate = sdf.format(date);
		RestTemplate restTemplate = new RestTemplate();

		String url = "http://api.fixer.io/" + historicalDate + "?base=" + fromCurrency + "&symbols=" + fromCurrency
				+ "," + toCurrency;
		ExchangeRate rates = restTemplate.getForObject(url, ExchangeRate.class);

		return rates;
	}
}
