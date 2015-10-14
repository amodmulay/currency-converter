package com.avm.zoocode.web;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.avm.zoocode.service.dto.UserDetailsExt;

@ControllerAdvice
public class CurrentUserControllerAdvice {
	@ModelAttribute("currentUser")
	public UserDetailsExt getCurrentUser(Authentication authentication) {
		return (authentication == null) ? null : (UserDetailsExt) authentication.getPrincipal();
	}

}
