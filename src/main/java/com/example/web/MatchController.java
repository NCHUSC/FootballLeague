package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MatchController {

    //跳转至添加比赛页面
    @GetMapping("/matchInformation")
    public String toAddInformationPage(){
        return "match/addMatchInformation";
    }

    //跳转至添加比赛结果页面
    @GetMapping("/matchResult")
    public String toAddResultPage(){
        return "match/addMatchResult";
    }

    //跳转至查询比赛页面
    @GetMapping("/queryMatch")
    public String toQueryPage(){
        return "match/queryMatch";
    }

    //跳转至查询结果页面
    @GetMapping("/showMatch")
    public String toShowPage(){
        return "match/showMatch";
    }

    //跳转至比赛信息页面
    @GetMapping("/matches")
    public String toMatchesPage(){
        return "match/matches";
    }

}
