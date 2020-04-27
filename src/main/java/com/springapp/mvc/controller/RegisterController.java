package com.springapp.mvc.controller;

import com.springapp.mvc.dto.UserRegistDTO;
import com.springapp.mvc.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @GetMapping(value = "/regist")
    public String getRegistPage(Model model){

            model.addAttribute("message", "Register page");
            return "register";

    }


    @PostMapping(value = "/regist")
    public String registNewUser(@ModelAttribute("userRegistDTO") UserRegistDTO userRegistDTO){

            registerService.addRegisterUser(userRegistDTO);
            return "index";

    }
}
