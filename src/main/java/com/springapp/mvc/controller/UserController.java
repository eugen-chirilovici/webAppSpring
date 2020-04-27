package com.springapp.mvc.controller;

import com.springapp.mvc.dto.CredentialsDTO;
import com.springapp.mvc.dto.DeleteUserDTO;
import com.springapp.mvc.dto.UserDTO;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.User;
import com.springapp.mvc.model.enums.RoleType;
import com.springapp.mvc.service.AuthenticationService;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    private org.springframework.security.core.userdetails.User loggedUser;

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hi there! Please, log in if you want to access our page");
        return "index";
    }

    @GetMapping(value = "/login")
    public String submitLogin(ModelMap model) {

        model.addAttribute("message", "Hi there! Please, log in if you want to access our page");
        return "index";
    }

    @GetMapping(value = "/welcome")
    public String logIn() {
        loggedUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();

        if (loggedUser != null) {
            if (loggedUser.getAuthorities().contains(new SimpleGrantedAuthority(RoleType.ROLE_ADMIN.getValue()))){
                return "redirect:/welcome";
            } else if (loggedUser.getAuthorities().contains(new SimpleGrantedAuthority(RoleType.ROLE_USER.getValue())))
                return "redirect:/personalCab";
        } return "/error";
    }

    @GetMapping(value = "/personal")
    public String showPersonalData(Model model) {
        List<UserDTO> listOfUsers = new ArrayList<>();
        UserDTO userDTO = new UserDTO();
        com.springapp.mvc.model.User user = userService.getUserByUsername(loggedUser.getUsername());
        userDTO.setUser(user);
        listOfUsers.add(userDTO);

        model.addAttribute("users", listOfUsers);
        model.addAttribute("title", "Personal Cabinet");
        model.addAttribute("message", "Personal data:");
        return "personalCab";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public String deleteUser(@ModelAttribute("deleteUserDTO") DeleteUserDTO deleteUserDTO) {

        if(deleteUserDTO.getDeletedUserId() < 1 || deleteUserDTO.getDeletedUserId() > userService.getAllUsers().size() - 1)
            return "redirect:/error";
        userService.removeUserById(deleteUserDTO);
        return "redirect:/welcome";
    }

    @GetMapping(value = "/moreInfo")
    public String getMorePersonalInformation(Model model) {
        List<UserDTO> listOfUsers = new ArrayList<>();
        UserDTO userDTO = new UserDTO();
        com.springapp.mvc.model.User user = userService.getUserByUsername(loggedUser.getUsername());
        userDTO.setUser(user);
        listOfUsers.add(userDTO);
        model.addAttribute("users", listOfUsers);
        model.addAttribute("title", "Advanced info");
        model.addAttribute("message", "More information:");
        return "moreInfo";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String errorConnection(ModelMap model) {
        model.addAttribute("errorMessage", "Invalid Details");
        return "error";
    }
}