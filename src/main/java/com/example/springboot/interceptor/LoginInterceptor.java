package com.example.springboot.interceptor;


import com.example.springboot.model.TxPerson;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        TxPerson user = (TxPerson) request.getSession().getAttribute("user");
        if(user != null){
            return true;
        }
        response.sendRedirect(request.getContextPath()+"/toLogin");
        return false;
    }
}
