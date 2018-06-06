package com.example.web;

import com.example.model.Team;
import com.example.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TeamController {
    @Autowired
    TeamService teamService;
    //跳转至添加球队页面
    @GetMapping("/team")
    public String toAddPage(){
        return "team/addTeam";
    }

    @PostMapping("/team")
    public String addTeam(Team team){
        //System.out.println("id="+team.getId()+" teamName="+team.getTeamName()+" shortName="+team.getShorterName()+" captainName="+team.getCaptainName()+" captainTel="+team.getCaptainTel()+" city="+team.getCity()+" home="+team.getHome()+" league="+team.getLeague());
        teamService.saveTeam(team);
        //来到球队列表页面
        //redirect:表示重定向到一个地址
        //forward：表示转发到一个地址
        return "redirect:/teams";
    }

    //跳转至查询球队页面
    @GetMapping("/queryTeam")
    public String toQueryPage(Model model){
        List<String> citys = teamService.selectTeamCity();
        model.addAttribute("citys",citys);
        List<String> leagues = teamService.selectTeamLeague();
        model.addAttribute("leagues",leagues);
        return "team/queryTeam";
    }

    //跳转至查询结果页面
    @PostMapping("/showTeam")
    public String toShowPage(Team team,Model model){
        List<Team> teams = teamService.getTeam(team);
        model.addAttribute("tms",teams);
        // System.out.println(teams.get(0).toString());
        return "team/showTeam";
    }

    //跳转至球队信息页面
    @GetMapping("/teams")
    public String toTeamsPage(Model model){
        List<Team> teams = teamService.getAllTeam();
        model.addAttribute("teams",teams);
        return "team/teams";
    }

    /**
     * 查看球队
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/displayTeam")
    public String displayTeam(Integer id,Model model){
        //System.out.println("查看球队的id："+id);
        List<Team> teams = teamService.getTeamById(id);
        Team team = teams.get(0);
        model.addAttribute("team",team);
        return "team/displayTeam";
    }

    /**
     * 跳转到修改界面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/toModifyTeam")
    public String toModifyTeam(Integer id,Model model){
        List<Team> teams = teamService.getTeamById(id);
        Team team = teams.get(0);
        //System.out.println(team.toString()+"填入修改框");
        model.addAttribute("team",team);
        return "team/modifyTeam";
    }

    /**
     * 更新操作
     * @param team
     * @return
     */
    @PostMapping("/modifyTeam")
    public String modifyTeam(Team team){
        //System.out.println("修改："+team.toString());
        teamService.updateTeam(team);
        return "redirect:/teams";
    }

    //删除操作
    @GetMapping("/deleteTeam")
    public String deleteTeam(Integer id){
        //System.out.println(id);
        teamService.deleteTeam(id);
        return "redirect:/teams";
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
