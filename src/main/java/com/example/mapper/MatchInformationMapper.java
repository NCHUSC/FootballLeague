package com.example.mapper;

import com.example.model.MatchInformation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MatchInformationMapper {
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into matchInformation (league,round,matchDate,homeTeam,guestTeam,referee,city,field) values (#{league},#{round},#{matchDate},#{homeTeam},#{guestTeam},#{referee},#{city},#{field})")
    int saveMatchInformation(MatchInformation matchInformation);

    @Select("select * from matchInformation where league=#{league} order by id asc")
    public List<MatchInformation> getMatchInformationByLeague(String league);
}
