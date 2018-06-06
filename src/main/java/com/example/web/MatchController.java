package com.example.web;

import com.example.model.League;
import com.example.model.MatchInformation;
import com.example.model.MatchResult;
import com.example.model.Team;
import com.example.repository.LeagueRepository;
import com.example.service.MatchInformationService;
import com.example.service.MatchNewsService;
import com.example.service.PlayerService;
import com.example.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class MatchController {
    @Autowired
    MatchNewsService matchNewsService;
    @Autowired
    MatchInformationService matchInformationService;
    @Autowired
    TeamService teamService;
    @Autowired
    LeagueRepository leagueRepository;
    @Autowired
    PlayerService playerService;

    //跳转至添加比赛页面

    @GetMapping("/selectLeague")
    public String selectLeague(Model model){
        List<League> leagues = leagueRepository.findAll();
        model.addAttribute("leagues",leagues);
        return "match/selectLeague";
    }

    @PostMapping("/matchInformation")
    public String matchInformation(League league,Model model){
        System.out.println(league);
        System.out.println("所选联赛："+league.getLeagueName());
        List<Team> teams =  teamService.getTeamByLeague(league.getLeagueName());
        System.out.println("参加该联赛球队数："+teams.size());
        String mr;
        int j=1;
        List<String> matchRounds = new ArrayList<>();

        for(int i=0;i<teams.size()-1;i++){
            mr = "第"+j+"轮";
            System.out.println(mr);
            j++;
            matchRounds.add(mr);
        }
        //System.out.println(matchRounds.get(0)+matchRounds.get(1));
        model.addAttribute("league",league);
        model.addAttribute("teams",teams);
        model.addAttribute("matchRounds",matchRounds);
        return "match/addMatchInformation";
    }

    @PostMapping("/addMatchInformationFinish")
    public String addMatchFinish(MatchInformation matchInformation){
        matchInformationService.saveMatchInformation(matchInformation);
        return "redirect:/matches";
    }

    //跳转至查询比赛页面
    @GetMapping("/queryMatch")
    public String toQueryPage(Model model){
        Collection<Team> teams = playerService.selectAllTeam();
        model.addAttribute("teams",teams);
        return "match/queryMatch";
    }


    //跳转至比赛信息页面
    @GetMapping("/matches")
    public String toMatchesPage(Model model){
        List<MatchInformation> matchInformations = matchInformationService.getAllMatchInformation();
        model.addAttribute("matchInformations",matchInformations);
        return "match/matches";
    }

    @GetMapping("/displayMatchInformation")
    public String displayMatchInformation(Integer id,Model model){
        MatchInformation matchInformation = matchInformationService.getMatchInformationById(id);
        model.addAttribute("matchInformation",matchInformation);
        MatchResult matchResult = matchNewsService.getMatchResultByMatchId(id);
        if(matchResult==null){
            matchResult = new MatchResult();
            matchResult.setHomeGoals(-1);
            matchResult.setGuestGoals(-1);
            matchResult.setScore("比赛未结束，比分未知！");
            matchResult.setWinner("比赛未结束，胜者未知！");
        }
        model.addAttribute("matchResult",matchResult);
        //System.out.println(matchResult.toString());
        return "match/displayMatchInformation";
    }

}
