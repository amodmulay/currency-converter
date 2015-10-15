package com.avm.zoocode.webservice.rest;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.avm.zoocode.webservice.rest.json.ExchangeRate;

@Component
public class FixerECBRateConsumer implements RestRateConsumer<ExchangeRate>{

	public static void main(String args) {
		RestTemplate restTemplate = new RestTemplate();
        ExchangeRate quote = restTemplate.getForObject("http://api.fixer.io/latest", ExchangeRate.class);
        System.out.println(quote.toString());
	}
	
	public ExchangeRate getAllExchangeRates()
	{
		RestTemplate restTemplate = new RestTemplate();
		 ExchangeRate rates = restTemplate.getForObject("http://api.fixer.io/latest", ExchangeRate.class);
		 return rates;
	}
}
