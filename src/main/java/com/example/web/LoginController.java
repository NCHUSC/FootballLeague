package com.example.web;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/login")
    public String login(User user1,Map<String,Object> map,HttpSession session){
        String account=user1.getAccount();
        String password=user1.getPassword();
        System.out.println(account+" "+password);

        User user2=userRepository.findByAccount(account);
        String tel=user2.getTel();
        if(user2==null){
            // 用户名不存在，登录失败
            map.put("msg","用户名或密码错误");
            return "login";
        }
        else if(!password.equals(user2.getPassword())){
            // 密码错误，登录失败
            map.put("msg","用户名或密码错误");
            return "login";
        }
        else{
            // 登录成功
            session.setAttribute("loginUser",account);
            session.setAttribute("tel",tel);
            return "redirect:/index.html";
        }
        /*return "index";*/
    }

}
