package app.mvc.controller;

import app.mvc.dto.UserRegistDTO;
import app.mvc.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "/regist", method = RequestMethod.GET)
    public String getRegistPage(Model model){
        model.addAttribute("message", "Register page");
        return "register";
    }


    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public String registNewUser(@ModelAttribute("userRegistDTO") UserRegistDTO userRegistDTO){
        if (userRegistDTO.getAge() < 0 || userRegistDTO.getAge() > 150)
            return "error";
        if (registerService.loginValidator(userRegistDTO.getUsername()))
            return "error";
        if (userRegistDTO.getPassword().length() < 4)
            return "error";// less than 4 because automatically created users have the password "test"
        registerService.addRegisterUser(userRegistDTO);
        return "index";
    }
}
