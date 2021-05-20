package com.example.mapper;

import com.example.model.MatchInformation;
import com.example.model.MatchResult;
import com.example.model.PlayerSkill;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;

public interface MatchResultMapper {

    /**
     * 无条件查询出所有比赛信息
     *
     * @return
     */
    @Select("select * from matchinformation")
    public Collection<MatchInformation> selectAllMatchNews();

    /**
     * 根据 id 查询出该场比赛信息
     *
     * @param id
     * @return
     */
    @Select("select * from matchinformation where id=#{id}")
    public MatchInformation selectMatchNewById(Integer id);

    /**
     * 给球员技术统计表添加球员比赛技术统计信息
     *
     * @param playerSkill
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into player_skill(number,name,goals,result_id) values(#{number},#{name},#{goals},#{resultId})")
    public int insertPlayerSkill(PlayerSkill playerSkill);

    /**
     * 给比赛结果表添加比赛结果信息
     *
     * @param matchResult
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into match_result(rleague,rmatch_date,rhome_team,rguest_team,score,winner,home_goals,guest_goals,match_id) values(#{rleague},#{rmatchDate},#{rhomeTeam},#{rguestTeam},#{score},#{winner},#{homeGoals},#{guestGoals},#{matchId})")
    public int insertMatchResult(MatchResult matchResult);

    /**
     * 根据 id 更新该场比赛的比赛状态
     *
     * @param state
     * @param id
     */
    @Select("update matchinformation set state=#{state} where id=#{id}")
    public void updateStateById(@Param("state") String state, @Param("id") Integer id);

    /**
     * 根据比赛日期查询出所有比赛信息
     *
     * @param matchDate
     * @return
     */
    @Select("select * from matchinformation where matchDate=#{matchDate}")
    public Collection<MatchInformation> selectMatchNewsByDate(String matchDate);

    /**
     * 根据比赛轮次查询出所有比赛信息
     *
     * @param round
     * @return
     */
    @Select("select * from matchinformation where round=#{round}")
    public Collection<MatchInformation> selectMatchNewsByRound(String round);

    /**
     * 根据球队名查询出所有比赛信息
     *
     * @param team
     * @return
     */
    @Select("select * from matchinformation where homeTeam=#{team} or guestTeam=#{team}")
    public Collection<MatchInformation> selectMatchNewsByTeam(@Param("team") String team);

    /**
     * 根据比赛 id 来查询比赛结果
     *
     * @param matchId
     * @return
     */
    @Select("select * from match_result where match_id=#{matchId}")
    public MatchResult getMatchResultByMatchId(Integer matchId);
}
