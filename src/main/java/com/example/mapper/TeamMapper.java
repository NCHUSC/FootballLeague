package com.example.mapper;

import com.example.model.Team;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface TeamMapper {

    @Select("select * from team")
    public List<Team> getAllTeam();

    @Select("select * from team where id=#{id}")
    public List<Team> getTeamById(Integer id);

    @Select("select * from team where teamName=#{teamName}")
    public List<Team> getTeamByTeamName(String team_name);

    @Select("select * from team where home=#{home}")
    public List<Team> getTeamByHome(String home);

    @Select("select * from team where city=#{city}")
    public List<Team> getTeamByCity(String city);

    @Select("select * from team where league=#{league}")
    public List<Team> getTeamByLeague(String league);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into team (teamName,shorterName,captainName,captainTel,home,city,league) values (#{teamName},#{shorterName},#{captainName},#{captainTel},#{home},#{city},#{league})")
    public int save(Team team);

    @Update("update team set teamName=#{teamName}, shorterName=#{shorterName}, captainName=#{captainName}, captainTel=#{captainTel}, home=#{home}, city=#{city}, league=#{league} where id=#{id}")
    public int updateTeam(Team team);

    @Delete("delete from team where id=#{id}")
    public int deleteTeamById(Integer id);

}
