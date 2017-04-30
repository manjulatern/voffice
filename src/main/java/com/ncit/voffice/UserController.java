package com.ncit.voffice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ncit.api.UserService;
import com.ncit.entity.User;
import com.ncit.model.UserServiceImpl;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	UserService usrService = new UserServiceImpl();

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listAll(Model model) {
		logger.info("Welcome to Users module!");

		List<User> userList = usrService.getUserList();

		// sends rolelist to list view as roles
		model.addAttribute("users", userList);

		return "users/list";
	}

}
