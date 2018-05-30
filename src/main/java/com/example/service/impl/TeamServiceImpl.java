package com.example.service.impl;

import com.example.mapper.TeamMapper;
import com.example.model.Team;
import com.example.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamMapper teamMapper;

    @Override
    public int saveTeam(Team team) {
        return teamMapper.save(team);
    }

    @Override
    public List<Team> getAllTeam() {
        return teamMapper.getAllTeam();
    }

    @Override
    public List<Team> getTeam(Team team) {
        System.out.println("传递给Service的对象："+team.toString());
        //System.out.println(!team.getTeamName().isEmpty());
        if(team.getId()!=0){
            System.out.println("按id查询");
            return teamMapper.getTeamById(team.getId());
        }else if(team.getTeamName()!=null){
            System.out.println("按球队名称查询");
            return teamMapper.getTeamByTeamName(team.getTeamName());
        }else if(team.getHome()!=null){
            System.out.println("按主场查询");
            return teamMapper.getTeamByHome(team.getHome());
        }else if(team.getCity()!=null){
            System.out.println("按城市查询");
            return teamMapper.getTeamByCity(team.getCity());
        }else if(team.getLeague()!=null){
            System.out.println("按联赛查询");
            return teamMapper.getTeamByLeague(team.getLeague());
        }else return null;
    }

    @Override
    public List<Team> getTeamById(Integer id) {
        return teamMapper.getTeamById(id);
    }

    @Override
    public List<Team> getTeamByLeague(String league) {
        return teamMapper.getTeamByLeague(league);
    }

    @Override
    public int updateTeam(Team team) {
        return teamMapper.updateTeam(team);
    }

    @Override
    public int deleteTeam(Integer id) {
        return teamMapper.deleteTeamById(id);
    }
}
