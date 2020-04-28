package app.mvc.controller;

import app.mvc.dto.DeleteUserDTO;
import app.mvc.dto.UserDTO;
import app.mvc.model.enums.RoleType;
import app.mvc.service.AuthenticationService;
import app.mvc.service.UserService;
import app.mvc.util.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationService authenticationService;

    private User loggedUser;

    private app.mvc.model.User user;

    @RequestMapping(value = "/welcome")
    public String submit() {
        loggedUser = AppUtils.getLoggedUser();

        if (loggedUser != null) {
            if (loggedUser.getAuthorities().contains(new SimpleGrantedAuthority(RoleType.ROLE_ADMIN.getValue()))) {
                return "redirect:/allusers";
            } else if (loggedUser.getAuthorities().contains(new SimpleGrantedAuthority(RoleType.ROLE_USER.getValue()))) {
                return "redirect:/personal";
            }
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
        listOfUsers.add(AppUtils.userConvert(userService.getUserByUserName(loggedUser.getUsername())));

        model.addAttribute("users", listOfUsers);
        model.addAttribute("title", "Personal Cabinet");
        model.addAttribute("message", "Personal data:");
        return "personalCab";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteUser(@ModelAttribute("deleteUserDTO") DeleteUserDTO deleteUserDTO) {
        if (deleteUserDTO.getRequiredID_Delete() > authenticationService.IDlength())
            return "error";
        userService.deleteUser(deleteUserDTO.getRequiredID_Delete());
        return "redirect:/allusers";
    }

    @RequestMapping(value = "/parsedData", method = RequestMethod.GET)
    public  String stringdata(Model model) {
        loggedUser = AppUtils.getLoggedUser();
        model.addAttribute("user", userService.getUserByUserName(loggedUser.getUsername()));
        return "parsedData";
    }

    @RequestMapping(value = "/moreDetails", method = RequestMethod.GET)
    public String showMoreDetails(ModelMap model) {
        loggedUser = AppUtils.getLoggedUser();

        List<app.mvc.model.User> listOfUsers = new ArrayList<>();
        listOfUsers.add(userService.getUserByUserName(loggedUser.getUsername()));

        model.addAttribute("users", listOfUsers);
        model.addAttribute("title", "All Personal Data");
        model.addAttribute("message", "More details");

        return "moreDetails";
    }
}