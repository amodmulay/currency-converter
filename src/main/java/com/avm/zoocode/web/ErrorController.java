package com.avm.zoocode.web;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController implements org.springframework.boot.autoconfigure.web.ErrorController {
	@RequestMapping("/error")
	public ModelAndView getErrorPage(@RequestParam Optional<String> error) {
		return new ModelAndView("error", "error", error);
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}
