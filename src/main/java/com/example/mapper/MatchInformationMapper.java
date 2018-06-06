package com.example.mapper;

import com.example.model.MatchInformation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MatchInformationMapper {
    /**
     * 插入比赛信息
     * @param matchInformation
     * @return
     */
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into matchInformation (league,round,matchDate,homeTeam,guestTeam,referee,city,field,state) values (#{league},#{round},#{matchDate},#{homeTeam},#{guestTeam},#{referee},#{city},#{field},#{state})")
    int saveMatchInformation(MatchInformation matchInformation);

    /**
     * 查询所有的比赛信息
     * @return
     */
    @Select("select * from matchInformation")
    public List<MatchInformation> getAllMatchInformation();

    /**
     * 根据id查询比赛信息
     * @param id
     * @return
     */
    @Select("select * from matchInformation where id=#{id}")
    public MatchInformation getMatchInformationById(Integer id);

    /**
     * 根据联赛查询比赛信息
     * @param league
     * @return
     */
    @Select("select * from matchInformation where league=#{league} order by id asc")
    public List<MatchInformation> getMatchInformationByLeague(String league);
}
