package com.example.service;

import com.example.model.*;
import com.example.model.PlayerSkill;

import java.util.Collection;

public interface MatchNewsService {

    public Collection<MatchInformation> selectAllMatchNews();

    public MatchInformation selectMatchNewById(int id);

    public int insertPlayerSkill(PlayerSkill playerSkill);

    public int insertMatchResult(MatchResult matchResult);

    public void updateStateById(String state,int id);

    public Collection<MatchInformation> selectMatchNewsByDate(String matchDate);

    public Collection<MatchInformation> selectMatchNewsByRound(String round);

    public Collection<MatchInformation> selectMatchNewsByTeam(String team);

    public MatchResult getMatchResultByMatchId(int matchId);
}
