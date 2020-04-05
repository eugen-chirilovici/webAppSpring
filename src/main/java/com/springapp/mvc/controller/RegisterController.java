package com.springapp.mvc.controller;

import com.springapp.mvc.dto.UserRegistDTO;
import com.springapp.mvc.service.RegisterService;
import com.springapp.mvc.validation.Validation;
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
        if(Validation.registerValidation(userRegistDTO) && Validation.loginValidation(registerService, userRegistDTO.getLogin())){
            registerService.addRegisterUser(userRegistDTO);
            return "index";
        }
        return "error";
    }
}
