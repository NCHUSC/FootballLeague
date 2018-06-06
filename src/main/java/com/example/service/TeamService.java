package com.example.service;

import com.example.model.Team;


import java.util.List;


public interface TeamService {

    /**
     * 添加球队
     * @param team
     */
    int saveTeam(Team team);

    /**
     * 查询所有球队
     * @return
     */
    List<Team> getAllTeam();

    /**
     * 查询球队
     * @param team
     * @return
     */
    List<Team> getTeam(Team team);

    /**
     * 按id查询
     * @param id
     * @return
     */
    List<Team> getTeamById(Integer id);

    /**
     * 按所属联赛查询球队
     * @param league
     * @return
     */
    List<Team> getTeamByLeague(String league);

    /**
     * 修改球队
     * @param team
     */
    int updateTeam (Team team);

    /**
     * 删除球队
     * @param id
     */
    int deleteTeam (Integer id);

    /**
     * 查询所有队伍的所在城市
     * @return
     */
    List<String> selectTeamCity();

    /**
     * 查询所有联赛
     * @return
     */
    List<String> selectTeamLeague();
}
