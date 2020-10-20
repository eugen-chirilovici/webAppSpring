package com.springapp.mvc.controller;

import com.springapp.mvc.dto.UserRegistDTO;
import com.springapp.mvc.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.regex.Pattern;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "/regist", method = RequestMethod.GET)
    public String getRegistPage(Model model) {
        model.addAttribute("message", "Register page");
        return "register";
    }


    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public String registNewUser(@Validated @ModelAttribute("userRegistDTO") UserRegistDTO userRegistDTO) {
        try {
            registerService.addRegisterUser(userRegistDTO);
            return "redirect:/";
        }catch (NullPointerException | NumberFormatException e){
            return "redirect:/errorLogin";
        }
    }

}
