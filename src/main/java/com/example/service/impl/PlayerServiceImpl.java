package com.example.service.impl;

import com.example.mapper.PlayerMapper;
import com.example.model.Player;
import com.example.model.Team;
import com.example.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerMapper playerMapper;

    @Override
    public Collection<Player> selectAllPlayer(){
        return playerMapper.selectAllPlayer();
    }

    @Override
    public Collection<Player> selectPlayerByName(String name){
        return playerMapper.selectPlayerByName(name);
    }

    @Override
    public Collection<Team> selectAllTeam(){
        return playerMapper.selectAllTeam();
    }

    @Override
    public Player queryPlayerByName(String name){
        return playerMapper.queryPlayerByName(name);
    }

    @Override
    public Collection<Player> selectPlayerByNumber(int number){
        return playerMapper.selectPlayerByNumber(number);
    }

    @Override
    public Collection<Player> selectPlayerByTeam(String team){
        return playerMapper.selectPlayerByTeam(team);
    }

    @Override
    public Collection<Player> selectPlayerByPosition(String position){
        return playerMapper.selectPlayerByPosition(position);
    }

    @Override
    public Collection<Player> selectPlayerByAge(int minAge,int maxAge){
        return playerMapper.selectPlayerByAge(minAge,maxAge);
    }

    @Override
    public Collection<Player> selectPlayerByHeight(int minHeight,int maxHeight){
        return playerMapper.selectPlayerByHeight(minHeight,maxHeight);
    }

    @Override
    public Collection<Player> selectPlayerByWeight(int minWeight,int maxWeight){
        return playerMapper.selectPlayerByWeight(minWeight,maxWeight);
    }

    @Override
    public Player selectPlayerById(int id){
        return playerMapper.selectPlayerById(id);
    }

    @Override
    public int insertPlayer(Player player){
        return playerMapper.insertPlayer(player);
    }

    @Override
    public int updatePlayer(Player player){
        return playerMapper.updatePlayer(player);
    }

    @Override
    public int deletePlayerById(int id){
        return playerMapper.deletePlayerById(id) ;
    }
}

