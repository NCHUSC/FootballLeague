package com.example.repository;

import com.example.model.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LeagueRepository extends JpaRepository<League,Integer> {

    //查询所有联赛并按id升序排列
    @Query(value = "select * from league order by start_date asc",nativeQuery = true)
    List<League> findAllOrderById();

    //通过联赛名称查询
    //@Query(value = "select * from league where league_name=?",nativeQuery = true)
    League findByLeagueName(String leagueName);

    //通过联赛名称模糊查询
    List<League> findByLeagueNameContaining(String leagueName);

    //通过联赛简称查询
    //@Query(value = "select * from league where shorter_name=?",nativeQuery = true)
    League findByShorterName(String shorterName);

    //通过联赛简称模糊查询
    List<League> findByShorterNameContaining(String shorterName);

    //通过开始日期查询
    @Query(value = "select * from league where start_date=? order by league_id asc",nativeQuery = true)
    List<League> findByStartDate(String startDate);

    //通过主办方查询
    //@Query(value = "select * from league where sponsor=? order by league_id asc",nativeQuery = true)
    List<League> findBySponsor(String sponsor);

    //通过主办方模糊查询
    List<League> findBySponsorContaining(String sponsor);

    //通过多条件（联赛名称、开始日期）查询
    List<League> findByLeagueNameContainingAndStartDate(String leagueName,String startDate);
}
