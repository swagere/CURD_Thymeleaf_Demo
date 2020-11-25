package com.kve.ems.controller;

import com.kve.ems.entity.User;
import com.kve.ems.service.UserService;
import com.kve.ems.utils.ValidateImageCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 注册
     * 和session中验证码进行比对
     * @param user
     * @return
     */
    @PostMapping("/register")
    public String register(User user, String code, HttpSession session) {
        String sessionCode = (String) session.getAttribute("code");
        if (sessionCode.equalsIgnoreCase(code)) {
            userService.register(user);
            return "redirect:/index";   //跳转到登录控制器
        }
        return "redirect:/toRegister";   //跳转到注册控制器
    }


    /**
     * 生成验证码
     * @param session
     * @param response
     */
    @GetMapping("/code")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
        //生成验证码
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);

        //存入session作用域中，便于后期进行验证
        session.setAttribute("code", securityCode);

        //响应图片，输出到前端
        ServletOutputStream os = response.getOutputStream();
        ImageIO.write(image,"png", os);
    }
}
