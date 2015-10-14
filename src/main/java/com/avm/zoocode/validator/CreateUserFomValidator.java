package com.avm.zoocode.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.avm.zoocode.db.dto.UserDto;
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
    }

    private void validatePasswords(Errors errors, UserDto userDto) {
        if (!userDto.getPassword().equals(userDto.getPasswordRepeated())) {
            errors.reject("password.no_match", "Password Missmatch");
        }
    }

    private void validateEmail(Errors errors, UserDto userDto) {
        if (userService.getUserByEmail(userDto.getEmail()).isPresent()) {
            errors.reject("email.exists", "User with this email already exists");
        }
    }

}
