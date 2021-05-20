package com.example.web;

import com.example.model.*;
import com.example.service.MatchNewsService;
import com.example.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class MatchResultController {

    @Autowired
    MatchNewsService matchNewsService;

    @Autowired
    PlayerService playerService;

    /**
     * 跳转至比赛信息页面
     *
     * @param model
     * @return
     */
    @GetMapping("/matchResult")
    public String toMatchNewsPage(Model model) {
        Collection<MatchInformation> matchInformations = matchNewsService.selectAllMatchNews();
        model.addAttribute("matchInformations", matchInformations);
        return "match/showMatchInformation";
    }

    /**
     * 跳转至添加比赛结果页面
     *
     * @param matchInformation
     * @param model
     * @return
     */
    @PostMapping("/addMatchResultPage")
    public String toAddMatchResultPage(MatchInformation matchInformation, Model model) {
        MatchInformation matchInformation1 = matchNewsService.selectMatchNewById(matchInformation.getId());
        Collection<Player> homeTeamPlayers = playerService.selectPlayerByTeam(matchInformation.getHomeTeam());
        Collection<Player> guestTeamPlayers = playerService.selectPlayerByTeam(matchInformation.getGuestTeam());
        model.addAttribute("matchInformation1", matchInformation1);
        model.addAttribute("homeTeamPlayers", homeTeamPlayers);
        model.addAttribute("guestTeamPlayers", guestTeamPlayers);
        return "match/addMatchResult";
    }

    /**
     * 添加比赛结果
     *
     * @param matchResult
     * @return
     */
    @GetMapping("/addMatchResult")
    public String addMatchResult(MatchResult matchResult) {
        String score = matchResult.getGuestGoals() + ":" + matchResult.getHomeGoals();
        matchResult.setScore(score);
        matchNewsService.insertMatchResult(matchResult);
        String state = "已结束";
        matchNewsService.updateStateById(state, matchResult.getMatchId());
        return "redirect:matchResult";
    }

    /**
     * 给球员技术统计表添加数据
     *
     * @param playerSkill
     * @param matchInformation
     * @return
     */
    @PostMapping("/insertPlayerSkill")
    public String insertPlayerSkill(PlayerSkill playerSkill, MatchInformation matchInformation) {
        System.out.println("球员技术:" + playerSkill.getName() + playerSkill.getGoals());
        int number = playerService.queryPlayerByName(playerSkill.getName()).getNumber();
        playerSkill.setNumber(number);
        playerSkill.setResultId(matchInformation.getId());
        matchNewsService.insertPlayerSkill(playerSkill);
        return "forward:addMatchResultPage";
    }

}
