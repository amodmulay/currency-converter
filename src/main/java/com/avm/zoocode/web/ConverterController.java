package com.avm.zoocode.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.avm.zoocode.service.currency.CurrencyConverterService;
import com.avm.zoocode.service.dto.UserDto;
import com.avm.zoocode.service.dto.currency.ExchangeRateDto;
import com.avm.zoocode.service.dto.currency.ExchangeRequestDto;
import com.avm.zoocode.service.user.UserService;
import com.avm.zoocode.validator.ConvertFormValidator;

@Controller
public class ConverterController {
	@Autowired
	private CurrencyConverterService converterService;

	@Autowired
	private UserService userService;

	@Autowired
	private ConvertFormValidator convertFormValidator;
	 
	
	@InitBinder("ExchangeRequestDto")
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(convertFormValidator);
	}

	@RequestMapping(value = "/converter", method = RequestMethod.GET)
	public ModelAndView getConverter() {

		Map<String, Object> modelMap = new HashMap<String, Object>();
		ExchangeRateDto exchangeRateDto = converterService.getAllCurrencyRates();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		// user is logged in so no need to check
		UserDto user = userService.getUserByEmail(auth.getName()).get();
		modelMap.put("activity", user.getActivityLog());
		modelMap.put("rates", exchangeRateDto);
		modelMap.put("convert", new ExchangeRequestDto());
		return new ModelAndView("converter", modelMap);
	}

	@RequestMapping(value = "/converter", method = RequestMethod.POST)
	public ModelAndView convert(@Valid @ModelAttribute("ExchangeRequestDto") ExchangeRequestDto exchangeRequestDto,
			BindingResult bindingResult) {
		
		if (null != exchangeRequestDto.getRateDate()) {
			exchangeRequestDto = converterService.getHistoricalConvertedValue(exchangeRequestDto.getFromCurreny(),
					exchangeRequestDto.getToCurrency(), exchangeRequestDto.getValueToConvert(),
					exchangeRequestDto.getRateDate());
		} else {
			exchangeRequestDto = converterService.getConvertedValue(exchangeRequestDto.getFromCurreny(),
					exchangeRequestDto.getToCurrency(), exchangeRequestDto.getValueToConvert());
		}
		Map<String, Object> modelMap = new HashMap<String, Object>();
		ExchangeRateDto exchangeRateDto = converterService.getAllCurrencyRates();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		// user is logged in so no need to check
		UserDto user = userService.getUserByEmail(auth.getName()).get();
		modelMap.put("activity", user.getActivityLog());
		modelMap.put("rates", exchangeRateDto);
		modelMap.put("convert", exchangeRequestDto);
		return new ModelAndView("converter", modelMap);
	}

}
