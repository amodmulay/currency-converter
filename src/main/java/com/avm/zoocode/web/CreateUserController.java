package com.avm.zoocode.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.avm.zoocode.service.dto.UserDto;
import com.avm.zoocode.service.user.UserService;
import com.avm.zoocode.validator.CreateUserFomValidator;

@Controller
public class CreateUserController {
	private final UserService userService;
	private final CreateUserFomValidator createUserFomValidator;

	@Autowired
	public CreateUserController(UserService userService, CreateUserFomValidator CreateUserFomValidator) {
		this.userService = userService;
		this.createUserFomValidator = CreateUserFomValidator;
	}

	@InitBinder("userDto")
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(createUserFomValidator);
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView getCreateUserPage() {
		return new ModelAndView("create_user", "userDto", new UserDto());
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String handleUserCreateForm(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "create_user";
		}
		try {
			userService.create(userDto);
		} catch (DataIntegrityViolationException e) {
			bindingResult.reject("email.exists", "Email already registered");
			return "create_user";
		}
		return "redirect:/users";
	}
}
