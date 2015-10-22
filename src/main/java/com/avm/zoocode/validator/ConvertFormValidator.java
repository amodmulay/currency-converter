package com.avm.zoocode.validator;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.avm.zoocode.service.dto.currency.ExchangeRequestDto;

@Component
public class ConvertFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> claz) {
		return claz.equals(ExchangeRequestDto.class);
	}

	@Override
	public void validate(Object target, Errors error) {
		ExchangeRequestDto dto = (ExchangeRequestDto)target;
		if(null!=dto.getRateDate())
		{
			if(dto.getRateDate().after(new Date(System.currentTimeMillis())))
			{
				error.reject("rateDate.future","Sorry I cannot predict the future. So here is the rate for today!");
			}
		}

	}

}
