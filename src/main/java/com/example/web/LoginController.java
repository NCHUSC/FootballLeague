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
            //用户名不存在，登录失败
            map.put("msg","用户名或密码错误");
            return "login";
        }
        else if(!password.equals(user2.getPassword())){
            //密码错误，登录失败
            map.put("msg","用户名或密码错误");
            return "login";
        }
        else{
            //登录成功
            session.setAttribute("loginUser",account);
            session.setAttribute("tel",tel);
            return "redirect:/index.html";
        }
        /*return "index";*/
    }

    /*public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username)&&"123456".equals(password)){
            //登录成功，为了防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser",username);
            return "redirect:/index.html";
        }
        else{
            //登录失败
            map.put("msg","用户名或密码错误");
            return "login";
        }
    }*/

}
