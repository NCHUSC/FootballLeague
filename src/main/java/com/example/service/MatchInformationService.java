package com.example.service;

import com.example.model.MatchInformation;

import java.util.List;

public interface MatchInformationService {
    /**
     * 添加比赛信息
     *
     * @param matchInformation
     * @return
     */
    int saveMatchInformation(MatchInformation matchInformation);

    /**
     * 查询所有比赛信息
     *
     * @return
     */
    List<MatchInformation> getAllMatchInformation();

    /**
     * 根据 id 查询比赛信息
     *
     * @param id
     * @return
     */
    MatchInformation getMatchInformationById(Integer id);

    /**
     * 按联赛查询
     *
     * @param league
     * @return
     */
    List<MatchInformation> getMatchInformationByLeague(String league);
}
