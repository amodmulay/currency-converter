package com.avm.zoocode.web.restservice;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.avm.zoocode.AbstractZooCodApplicationTest;
import com.avm.zoocode.webservice.rest.json.ExchangeRate;

@WebAppConfiguration
@IntegrationTest("server.port:0")
public class RestServiceTest extends AbstractZooCodApplicationTest {

	@Value("${local.server.port}") // 6
	int port;

	@Test
	public void testConvertRestService() {
		RestTemplate restTemplate = new RestTemplate();
		ExchangeRate quote = restTemplate.getForObject("http://localhost:"+port+"/getrate?cur=EUR&to=INR",
				ExchangeRate.class);
		assertNotNull(quote);
	}
}
