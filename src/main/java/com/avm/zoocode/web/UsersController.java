package com.avm.zoocode.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.avm.zoocode.db.entity.User;
import com.avm.zoocode.db.repository.UserRepository;
import com.avm.zoocode.service.user.UserService;

@Controller
public class UsersController {
	
	@Autowired
	private UserRepository repository;

	@RequestMapping("/users")
	public ModelAndView getUsersPage() {
		return new ModelAndView("users", "users", repository.findAll());
	}

}
