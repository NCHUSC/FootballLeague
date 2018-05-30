package com.example.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//登录检查
public class LoginHandlerInterceptor implements HandlerInterceptor{
    /*//目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws ServletException, IOException {
        Object user=request.getSession().getAttribute("loginUser");
        if(user==null){
            //未登录，返回登录页面
            request.setAttribute("msg","没有权限，请先登录");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }
        else{
            //已登录
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){

    }

    @Override
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object handler,Exception e){

    }*/
}
