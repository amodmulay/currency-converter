package com.avm.zoocode.validator;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.avm.zoocode.service.dto.UserDto;
import com.avm.zoocode.service.user.UserService;

@Component
public class CreateUserFomValidator implements Validator {

	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> claz) {
		return claz.equals(UserDto.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserDto userDto = (UserDto) target;
		validatePasswords(errors, userDto);
		validateEmail(errors, userDto);
		validateBirthDate(errors, userDto);
	}

	private void validatePasswords(Errors errors, UserDto userDto) {
		if (!userDto.getPassword().equals(userDto.getPasswordRepeated())) {
			errors.reject("password.no_match", "Password Missmatch");
		}
	}

	private void validateEmail(Errors errors, UserDto userDto) {
		Optional<UserDto> optional = userService.getUserByEmail(userDto.getEmail());
		if (optional.isPresent()) {
			errors.reject("email.exists", "User with this email already exists");
		}
	}

	private void validateBirthDate(Errors errors, UserDto userDto) {
		Calendar cal = Calendar.getInstance();
		if (userDto.getBirthDate().after(new Date(System.currentTimeMillis()))) {
			errors.reject("birtdate.invalidfuture", "Back from the future? I think not! Correct your birthdate.");
		} else {

			cal.setTime(new Date(System.currentTimeMillis()));
			cal.add(Calendar.YEAR, -150);
			Date dateBefore150Years = cal.getTime();
			if (userDto.getBirthDate().before(dateBefore150Years)) {
				errors.reject("birtdate.invalidold",
						"You are 150 years old? Bravo! Lets get back to reality! Correct your birthdate.");
			}
			cal.setTime(new Date(System.currentTimeMillis()));
			cal.add(Calendar.YEAR, -10);
			Date dateBefore10Years = cal.getTime();
			if (userDto.getBirthDate().after(dateBefore10Years)) {
				errors.reject("birtdate.invalidyoung", "You are less than years old? Correct your birthdate.");
			}
		}

	}

}
