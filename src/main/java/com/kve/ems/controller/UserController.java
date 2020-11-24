package com.kve.ems.controller;

import com.kve.ems.utils.ValidateImageCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
