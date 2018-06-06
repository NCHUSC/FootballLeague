package com.example.web;

import com.example.model.MatchInformation;
import com.example.service.MatchNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class MatchNewsController {

    @Autowired
    MatchNewsService matchNewsService;

    //查询比赛信息
    @PostMapping("/matchNews_select")
    public String selectMatchNewsByDate(MatchInformation matchInformation, Model model){
        Collection<MatchInformation> matchNews1 = null;
        if(matchInformation.getMatchDate() != null){
            matchNews1 = matchNewsService.selectMatchNewsByDate(matchInformation.getMatchDate());
        }
        if(matchInformation.getRound() != null){
            matchNews1 = matchNewsService.selectMatchNewsByRound(matchInformation.getRound());
        }
        if(matchInformation.getTeam() != null){
            matchNews1 = matchNewsService.selectMatchNewsByTeam(matchInformation.getTeam());
        }
        model.addAttribute("matchNews1",matchNews1);
        return "match/showMatch";
    }
}
