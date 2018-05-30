package com.example.service;

import com.example.model.League;

import java.util.List;

public interface LeagueService {

    //保存联赛
    League saveLeague(League league);

    //删除联赛
    void deleteLeague(int league_id);

    //修改联赛
    League modifyLeague(League league);

    //通过id获取联赛
    League getLeaugeById(int league_id);

    //通过联赛名称获取联赛
    League getLeagueByName(String leagueName);

    //通过联赛名称模糊查询获取联赛
    List<League> getLeagueByNameLike(String leagueName);

    //通过联赛简称获取联赛
    League getLeagueByShorterName(String shorterName);

    //通过联赛简称模糊查询获取联赛
    List<League> getLeagueByShorterNameLike(String shorterName);

    //通过开始日期获取联赛
    List<League> getLeagueByStartDate(String startDate);

    //通过主办方获取联赛
    List<League> getLeagueBySponsor(String sponsor);

    //通过主办方模糊查询获取联赛
    List<League> getLeagueBySponsorLike(String sponsor);

    //获取所有联赛列表
    List<League> leagueList();
}
