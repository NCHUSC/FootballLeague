package com.example.mapper;

import com.example.model.Player;
import com.example.model.Team;
import org.apache.ibatis.annotations.*;

import java.util.Collection;

public interface PlayerMapper {

    /**
     * 无条件查询出所有球员
     *
     * @return
     */
    @Select("select * from player")
    public Collection<Player> selectAllPlayer();

    /**
     * 根据球员姓名查询出所有球员
     *
     * @param name
     * @return
     */
    @Select("select * from player where name=#{name}")
    public Collection<Player> selectPlayerByName(String name);

    /**
     * 根据球员姓名查询出给球员信息
     *
     * @param name
     * @return
     */
    @Select("select * from player where name=#{name}")
    public Player queryPlayerByName(String name);

    /**
     * 根据球员秋衣号码查询出所有球员
     *
     * @param number
     * @return
     */
    @Select("select * from player where number=#{number}")
    public Collection<Player> selectPlayerByNumber(Integer number);

    /**
     * 根据球队查询出所有球员
     *
     * @param team
     * @return
     */
    @Select("select * from player where team=#{team}")
    public Collection<Player> selectPlayerByTeam(String team);

    /**
     * 根据场上位置查询出所有球员
     *
     * @param position
     * @return
     */
    @Select("select * from player where position=#{position}")
    public Collection<Player> selectPlayerByPosition(String position);

    /**
     * 根据年龄范围查询出所有球员
     *
     * @param minAge
     * @param maxAge
     * @return
     */
    @Select("select * from player where age between #{minAge} and #{maxAge}")
    public Collection<Player> selectPlayerByAge(@Param("minAge") Integer minAge, @Param("maxAge") Integer maxAge);

    /**
     * 根据身高范围查询出所有球员
     *
     * @param minHeight
     * @param maxHeight
     * @return
     */
    @Select("select * from player where height between #{minHeight} and #{maxHeight}")
    public Collection<Player> selectPlayerByHeight(@Param("minHeight") Integer minHeight, @Param("maxHeight") Integer maxHeight);

    /**
     * 根据体重范围查询出所有球员
     *
     * @param minWeight
     * @param maxWeight
     * @return
     */
    @Select("select * from player where weight between #{minWeight} and #{maxWeight}")
    public Collection<Player> selectPlayerByWeight(@Param("minWeight") Integer minWeight, @Param("maxWeight") Integer maxWeight);

    /**
     * 根据id查出该球员信息
     *
     * @param id
     * @return
     */
    @Select("select * from player where id=#{id}")
    public Player selectPlayerById(Integer id);

    /**
     * 无条件查询出所有球队
     *
     * @return
     */
    @Select("select * from team")
    public Collection<Team> selectAllTeam();

    /**
     * 给球员信息表添加球员
     *
     * @param player
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into player(name,team,number,position,height,weight,age) values(#{name},#{team},#{number},#{position},#{height},#{weight},#{age})")
    public int insertPlayer(Player player);

    /**
     * 更新球员信息
     *
     * @param player
     * @return
     */
    @Update("update player set name=#{name},team=#{team},number=#{number},position=#{position},height=#{height},weight=#{weight},age=#{age} where id=#{id}")
    public int updatePlayer(Player player);

    /**
     * 根据 id 删除该球员
     *
     * @param id
     * @return
     */
    @Delete("delete from player where id=#{id}")
    public int deletePlayerById(Integer id);
}

