package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PlayerController {

    //跳转至添加球员页面
    @GetMapping("/player")
    public String toAddPage(){
        return "player/addPlayer";
    }

    //跳转至查询球员页面
    @GetMapping("/queryPlayer")
    public String toQueryPage(){
        return "player/queryPlayer";
    }

    //跳转至查询结果页面
    @GetMapping("/showPlayer")
    public String toShowPage(){
        return "player/showPlayer";
    }

    //跳转至射手榜页面
    @GetMapping("/shooterboard")
    public String toShooterPage(){
        return "player/shooterboard";
    }

/*
    //跳转到添加球员界面
    @GetMapping("/player")
    public String toAddPage(Model model){
        List<Team> teamList=teamRepository.findAll();
        model.addAttribute("teams",teamList);
        return "player/addPlayer";
    }*/


}














