package com.example.springboot.SrcConfig;

import com.example.springboot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MVCConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/add").setViewName("add");
        registry.addViewController("/toLogin").setViewName("login");
        registry.addViewController("/main").setViewName("main");
    }



      //设置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePatterns = new ArrayList<String>();
        excludePatterns.add("/toLogin");
        excludePatterns.add("/login");
        excludePatterns.add("/add");

        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(excludePatterns);
        //排除 //拦截

    }
}
