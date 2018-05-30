package com.example.service.impl;

import com.example.model.League;
import com.example.repository.LeagueRepository;
import com.example.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LeagueServiceImpl implements LeagueService{

    @Autowired
    private LeagueRepository leagueRepository;

    //保存联赛
    @Transactional
    @Override
    public League saveLeague(League league) {
        return leagueRepository.save(league);
    }

    //删除联赛
    @Transactional
    @Override
    public void deleteLeague(int league_id) {
        leagueRepository.deleteById(league_id);
    }

    //修改联赛
    @Transactional
    @Override
    public League modifyLeague(League league) {
        return leagueRepository.save(league);
    }

    //通过id获取联赛
    @Override
    public League getLeaugeById(int league_id) {
        return leagueRepository.getOne(league_id);
    }

    //通过联赛名称获取联赛
    @Override
    public League getLeagueByName(String leagueName) {
        return leagueRepository.findByLeagueName(leagueName);
    }

    //通过联赛名称模糊查询获取联赛
    @Override
    public List<League> getLeagueByNameLike(String leagueName) {
        return leagueRepository.findByLeagueNameContaining(leagueName);
    }

    //通过联赛简称获取联赛
    @Override
    public League getLeagueByShorterName(String shorterName) {
        return leagueRepository.findByShorterName(shorterName);
    }

    //通过联赛简称模糊查询获取联赛
    @Override
    public List<League> getLeagueByShorterNameLike(String shorterName) {
        return leagueRepository.findByShorterNameContaining(shorterName);
    }

    //通过开始日期获取联赛
    @Override
    public List<League> getLeagueByStartDate(String startDate) {
        return leagueRepository.findByStartDate(startDate);
    }

    //通过主办方获取联赛
    @Override
    public List<League> getLeagueBySponsor(String sponsor) {
        return leagueRepository.findBySponsor(sponsor);
    }

    //通过主办方模糊查询获取联赛
    @Override
    public List<League> getLeagueBySponsorLike(String sponsor) {
        return leagueRepository.findBySponsorContaining(sponsor);
    }

    //获取所有联赛列表
    @Override
    public List<League> leagueList() {
        return leagueRepository.findAllOrderById();
        /*return leagueRepository.findAll();*/
    }
}
