package com.example.service.impl;

import com.example.mapper.MatchResultMapper;
import com.example.model.MatchInformation;
import com.example.model.MatchResult;
import com.example.model.PlayerSkill;
import com.example.service.MatchNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MatchNewsServiceImpl implements MatchNewsService {

    @Autowired
    MatchResultMapper matchResultMapper;

    @Override
    public Collection<MatchInformation> selectAllMatchNews(){
        return matchResultMapper.selectAllMatchNews();
    }

    @Override
    public MatchInformation selectMatchNewById(int id){
        return matchResultMapper.selectMatchNewById(id);
    }

    @Override
    public int insertPlayerSkill(PlayerSkill playerSkill){
        return matchResultMapper.insertPlayerSkill(playerSkill);
    }

    @Override
    public int insertMatchResult(MatchResult matchResult){
        return matchResultMapper.insertMatchResult(matchResult);
    }

    @Override
    public void updateStateById(String state,int id){
        matchResultMapper.updateStateById(state,id);
    }

    @Override
    public Collection<MatchInformation> selectMatchNewsByDate(String matchDate){
        return matchResultMapper.selectMatchNewsByDate(matchDate);
    }

    @Override
    public Collection<MatchInformation> selectMatchNewsByRound(String round){
        return matchResultMapper.selectMatchNewsByRound(round);
    }

    @Override
    public Collection<MatchInformation> selectMatchNewsByTeam(String team){
        return matchResultMapper.selectMatchNewsByTeam(team);
    }

    @Override
    public MatchResult getMatchResultByMatchId(int matchId){
        return matchResultMapper.getMatchResultByMatchId(matchId);
    }
}
