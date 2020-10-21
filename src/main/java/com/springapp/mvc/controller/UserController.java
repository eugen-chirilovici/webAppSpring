package com.springapp.mvc.controller;

import com.springapp.mvc.dto.CredentialsDTO;
import com.springapp.mvc.dto.UserDTO;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.User;
import com.springapp.mvc.model.enums.RoleType;
import com.springapp.mvc.service.AuthenticationService;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    private boolean invalidData = false;

    @Autowired
    private AuthenticationService authenticationService;

    private User loggedUser;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hi there! Please, log in if you want to access our page");
        if(invalidData){
            model.addAttribute("error","Invalid Password or Username");
            invalidData = false;
        }
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submit(@ModelAttribute("credentials") CredentialsDTO credentials) {

        Credentials userCredentials = authenticationService.confirmAuthentication(credentials);

        try {
            if(userCredentials.getLogin().isEmpty())throw new NullPointerException();
        }catch (NullPointerException e){
            e.printStackTrace();
            invalidData = true;
            return "redirect:/";
        }

        loggedUser = userService.getUserByCredentials(userCredentials);

        if (loggedUser != null) {
                return "redirect:/personal";
        }
        return "redirect:/error";
    }

    @RequestMapping(value = "/allusers", method = RequestMethod.GET)
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("title", "Admin Panel");
        model.addAttribute("message", "Here are all our users:");
        return "welcome";
    }

    @RequestMapping(value = "/personal", method = RequestMethod.GET)
    public String showPersonalData(Model model) {
        List<UserDTO> listOfUsers = new ArrayList<>();
        listOfUsers.add(userService.getUserById(loggedUser.getUserId()));

        model.addAttribute("users", listOfUsers);
        model.addAttribute("title", "Personal Cabinet");
        model.addAttribute("message", "Personal data:");
        return "personalCab";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String errorConnection(ModelMap model) {
        model.addAttribute("errorMessage", "Invalid Details");
        return "error";
    }

    @RequestMapping(value = "personal/more", method = RequestMethod.GET)
    public String moreDetails(ModelMap model) {

        RoleType loggedUserRole = authenticationService.getCredentialsDAO().getRoleByUserId(loggedUser.getCredentialsId());
        model.addAttribute("role", loggedUserRole.toString());
        if (loggedUser == null) return "error";
        if (loggedUserRole == RoleType.ROLE_ADMIN) {
            model.addAttribute("users", userService.getUserDTOwithRole());
        } else {
            model.addAttribute("id", loggedUser.getUserId());
            model.addAttribute("firstName", loggedUser.getFirstName());
            model.addAttribute("lastName", loggedUser.getLastName());
            model.addAttribute("phone", loggedUser.getPhoneNumber());
        }
        return "moreDetails";
    }

    @RequestMapping(value = "personal/more", method = RequestMethod.POST)
    public String deleteUser(@RequestParam String[] selectedTasks){
        if(selectedTasks == null)return "error";
        for(String id : selectedTasks) {
            try {
                userService.deleteUser(Long.parseLong(id));
            } catch (ConversionNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/personal/more";
    }
}
