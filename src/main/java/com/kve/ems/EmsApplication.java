package com.kve.ems;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
@MapperScan("com.kev.dao") //扫描所有dao接口
public class EmsApplication extends WebMvcConfigurationSupport {

    public static void main(String[] args) {
        SpringApplication.run(EmsApplication.class, args);
    }

    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //引入静态资源css、js无效时加上
//        registry.addResourceHandler("/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "templates/");
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
        super.addResourceHandlers(registry);
    }
}
