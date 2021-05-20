package com.example.service;

import com.example.model.League;

import java.util.List;

public interface LeagueService {

    /**
     * 保存联赛
     *
     * @param league
     * @return
     */
    League saveLeague(League league);

    /**
     * 删除联赛
     *
     * @param league_id
     */
    void deleteLeague(int league_id);

    /**
     * 修改联赛
     *
     * @param league
     * @return
     */
    League modifyLeague(League league);

    /**
     * 通过 id 获取联赛
     *
     * @param league_id
     * @return
     */
    League getLeaugeById(int league_id);

    /**
     * 通过联赛名称获取联赛
     *
     * @param leagueName
     * @return
     */
    League getLeagueByName(String leagueName);

    /**
     * 通过联赛名称模糊查询获取联赛
     *
     * @param leagueName
     * @return
     */
    List<League> getLeagueByNameLike(String leagueName);

    /**
     * 通过联赛简称获取联赛
     *
     * @param shorterName
     * @return
     */
    League getLeagueByShorterName(String shorterName);

    /**
     * 通过联赛简称模糊查询获取联赛
     *
     * @param shorterName
     * @return
     */
    List<League> getLeagueByShorterNameLike(String shorterName);

    /**
     * 通过开始日期获取联赛
     *
     * @param startDate
     * @return
     */
    List<League> getLeagueByStartDate(String startDate);

    /**
     * 通过主办方获取联赛
     *
     * @param sponsor
     * @return
     */
    List<League> getLeagueBySponsor(String sponsor);

    /**
     * 通过主办方模糊查询获取联赛
     *
     * @param sponsor
     * @return
     */
    List<League> getLeagueBySponsorLike(String sponsor);

    /**
     * 获取所有联赛列表
     *
     * @return
     */
    List<League> leagueList();
}
