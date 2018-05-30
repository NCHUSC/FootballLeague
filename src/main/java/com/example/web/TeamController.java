package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class TeamController {

    //跳转至添加球队页面
    @GetMapping("/team")
    public String toAddPage(){
        return "team/addTeam";
    }

    //跳转至查询球队页面
    @GetMapping("/queryTeam")
    public String toQueryPage(){
        return "team/queryTeam";
    }

    //跳转至查询结果页面
    @GetMapping("/showTeam")
    public String toShowPage(){
        return "team/showTeam";
    }

    //跳转至球队信息页面
    @GetMapping("/teams")
    public String toTeamsPage(){
        return "team/teams";
    }

    //跳转至球队积分排名（积分榜）页面
    @GetMapping("/scoreboard")
    public String toScorePage(){
        return "team/scoreboard";
    }


    /*@RequestMapping(value = "/scoreboard",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String toScorePage(HttpServletResponse response){
        *//*return "team/scoreboard";*//*
        response.addHeader("Access-Control-Allow-Origin","*");
        return "{\"url\":\"http://localhost:8080/json/teams.json\"}";
    }*/

}
