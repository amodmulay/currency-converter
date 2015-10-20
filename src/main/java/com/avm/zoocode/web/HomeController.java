package com.avm.zoocode.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.avm.zoocode.service.currency.CurrencyConverterService;

@Controller
public class HomeController {

	@Autowired
	CurrencyConverterService converterService;
	@RequestMapping("/")
	public ModelAndView getHomePage() {
		return new ModelAndView("home", "rates",converterService.getAllCurrencyRates() );
		
	}

}
