package com.avm.zoocode.web.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avm.zoocode.websconsumer.rest.FixerECBRateConsumer;
import com.avm.zoocode.webservice.rest.json.ExchangeRate;

@RestController
public class ConverterRestService {

	@Autowired
	FixerECBRateConsumer fixerService;

	@RequestMapping("/getrate")
    public ExchangeRate greeting(@RequestParam(value="cur", defaultValue="EUR") String base, @RequestParam(value="to", defaultValue="USD") String to) {
        return fixerService.getExchangeRate(base, to);
    }
}
