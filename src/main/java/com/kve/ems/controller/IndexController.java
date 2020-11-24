package com.kve.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @GetMapping("/index")
    public String toIndex(){
        return "login";
    }

    @GetMapping("/toRegister")
    public String toRegister(){
        return "register";
    }
}
