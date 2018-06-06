package com.example.service;

import com.example.model.Player;
import com.example.model.Team;

import java.util.Collection;

public interface  PlayerService {

    public Collection<Player> selectAllPlayer();

    public Collection<Player> selectPlayerByName(String name);

    public Player queryPlayerByName(String name);

    public Collection<Player> selectPlayerByNumber(int number);

    public Collection<Player> selectPlayerByTeam(String team);

    public Collection<Player> selectPlayerByPosition(String position);

    public Collection<Player> selectPlayerByAge(int minAge,int maxAge);

    public Collection<Player> selectPlayerByHeight(int minHeight,int maxHeight);

    public Collection<Player> selectPlayerByWeight(int minWeight,int maxWeight);

    public Player selectPlayerById(int id);

    public Collection<Team> selectAllTeam();

    public int insertPlayer(Player player);

    public int updatePlayer(Player player);

    public int deletePlayerById(int id);
}
