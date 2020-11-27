package com.kve.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    /**
     * 登陆控制器
     * @return
     */
    @GetMapping("/index")
    public String toIndex(){
        return "login";
    }

    /**
     * 注册控制器
     * @return
     */
    @GetMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    /**
     * 添加员工控制器
     * @return
     */
    @GetMapping("/toSave")
    public String toSave(){
        return "addEmp";
    }
}
