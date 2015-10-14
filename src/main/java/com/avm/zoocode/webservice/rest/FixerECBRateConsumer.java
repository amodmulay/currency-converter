package com.avm.zoocode.webservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.avm.zoocode.webservice.rest.json.ExchangeRate;

public class FixerECBRateConsumer {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
        ExchangeRate quote = restTemplate.getForObject("http://api.fixer.io/latest?symbols=USD,GBP", ExchangeRate.class);
        System.out.println(quote.toString());
	}
	
	@Autowired
	RestTemplate restTemplate;
	
	public ExchangeRate getAllExchangeRates()
	{
		 ExchangeRate rates = restTemplate.getForObject("http://api.fixer.io/latest?symbols=USD,GBP", ExchangeRate.class);
		 return rates;
	}
}
