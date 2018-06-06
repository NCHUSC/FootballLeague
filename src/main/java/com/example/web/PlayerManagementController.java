package com.example.web;

import com.example.model.Player;
import com.example.model.Team;
import com.example.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class PlayerManagementController {

    @Autowired
    PlayerService playerService;

    //将查出来的球员列表返回给页面显示
    @PostMapping("/player_select")
    public String selectPlayer(Player player,Model model){
        Collection<Player> players = null;
        if(player.getName() != null) {
            players = playerService.selectPlayerByName(player.getName());
        }
        if(player.getNumber() != null){
            players = playerService.selectPlayerByNumber(player.getNumber());
        }
        if(player.getTeam() != null){
            players = playerService.selectPlayerByTeam(player.getTeam());
        }
        if(player.getPosition() != null){
            players = playerService.selectPlayerByPosition(player.getPosition());
        }
        //System.out.println("年龄:"+player.getMinAge()+player.getMaxAge());
        if(player.getMinAge() != null && player.getMaxAge() != null){
            players = playerService.selectPlayerByAge(player.getMinAge(),player.getMaxAge());
        }
        //System.out.println("shenggao:"+player.getMinHeight()+player.getMaxHeight());
        if(player.getMinHeight() != null && player.getMaxHeight() != null){
            int minHeight = Integer.parseInt(player.getMinHeight());
            int maxHeight = Integer.parseInt(player.getMaxHeight());
            players = playerService.selectPlayerByHeight(minHeight,maxHeight);
        }
        if(player.getMinWeight() != null && player.getMaxWeight() != null){
            int minWeight = Integer.parseInt(player.getMinWeight());
            int maxWeight = Integer.parseInt(player.getMaxWeight());
            players = playerService.selectPlayerByWeight(minWeight,maxWeight);
        }
        model.addAttribute("players",players);
        return "player/showPlayer";
    }

    //添加球员
    @PostMapping("/player_add")
    public String addPlayer(Player player){
        playerService.insertPlayer(player);
        return "index";
    }

    //跳转至球员信息更改页面
    @GetMapping("/player_update_switchpage")
    public String playerUpdateSwitchPage(Integer id, Model model){
        Player player = playerService.selectPlayerById(id);
        Collection<Team> teams = playerService.selectAllTeam();
        model.addAttribute("player",player);
        model.addAttribute("teams",teams);
        return "player/editPlayer";
    }

    //更新球员信息
    @PostMapping("/player_update")
    public String playerUpdate(Player player,Model model){
        playerService.updatePlayer(player);
        Collection<Player> players = playerService.selectAllPlayer();
        model.addAttribute("players",players);
        return "player/showPlayer";
    }

    //删除球员
    @GetMapping("/player_delete")
    public String deletePlayer(Integer id,Model model){
        playerService.deletePlayerById(id);
        Collection<Player> players = playerService.selectAllPlayer();
        model.addAttribute("players",players);
        return "player/showPlayer";
    }
}

