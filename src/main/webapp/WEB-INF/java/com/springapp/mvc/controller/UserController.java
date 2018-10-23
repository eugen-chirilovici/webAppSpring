package com.springapp.mvc.controller;

import com.springapp.mvc.model.User;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hi there! Please, log in if you want to access our secret page");
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("user") User user) {
		if (userService.checkUser(user)) {
			model.addAttribute(user);
			return "redirect:/allusers";
		} else {
			model.addAttribute("error", "Invalid Details");
			return "error";
		}
	}

	@RequestMapping(value = "/allusers", method = RequestMethod.GET)
	public String showAllUsers(ModelMap model) {
		model.addAttribute("users", userService.getAllUsers());
		return "welcome";
	}


	@RequestMapping(value = "/allusers/{gender}", method = RequestMethod.GET)
    public String showAllByGender(ModelMap model , @PathVariable() String gender) {
        model.addAttribute("users", userService.getAllByGender(gender));
        return "welcome";
    }
}