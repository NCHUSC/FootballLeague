package test.com.example.model; 

import com.example.FootballleagueManagementsystemApplication;
import com.example.model.League;
import com.example.service.LeagueService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.util.List;

/** 
* League Tester. 
* 
* @author <Hurley>
* @since <pre>五月 26, 2018</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FootballleagueManagementsystemApplication.class)
@WebAppConfiguration
public class LeagueTest {

    @Autowired
    private LeagueService leagueService;

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getLeague_id() 
* 
*/ 
@Test
public void testGetLeague_id() throws Exception { 
//TODO: Test goes here...
    League league=leagueService.getLeaugeById(164);
    System.out.println("联赛id："+league.getLeague_id());
} 

/** 
* 
* Method: setLeague_id(int league_id) 
* 
*/ 
@Test
public void testSetLeague_id() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getLeagueName() 
* 
*/ 
@Test
public void testGetLeagueName() throws Exception { 
//TODO: Test goes here...
    League league=leagueService.getLeagueByName("test1");
    System.out.println("联赛名称："+league.getLeagueName());
} 

/** 
* 
* Method: setLeagueName(String leagueName) 
* 
*/ 
@Test
@Transactional
@Rollback(false)
public void testSetLeagueName() throws Exception { 
//TODO: Test goes here...
    League league=leagueService.getLeagueByName("test1");
    league.setLeagueName("test");
    System.out.println("联赛名称："+league.getLeagueName());
} 

/** 
* 
* Method: getShorterName() 
* 
*/ 
@Test
public void testGetShorterName() throws Exception { 
//TODO: Test goes here...
    League league=leagueService.getLeagueByShorterName("test2");
    System.out.println("联赛简称："+league.getShorterName());
} 

/** 
* 
* Method: setShorterName(String shorterName) 
* 
*/ 
@Test
@Transactional
@Rollback(false)
public void testSetShorterName() throws Exception { 
//TODO: Test goes here...
    League league=leagueService.getLeagueByShorterName("test2");
    league.setShorterName("test");
    System.out.println("联赛简称："+league.getShorterName());
} 

/** 
* 
* Method: getStartDate() 
* 
*/ 
@Test
public void testGetStartDate() throws Exception { 
//TODO: Test goes here...
    List<League> leagueList=leagueService.getLeagueByStartDate("2018-05-20");
    for(League league:leagueList){
        System.out.println("开始日期："+league.getStartDate());
    }
} 

/** 
* 
* Method: setStartDate(String startDate) 
* 
*/ 
@Test
@Transactional
@Rollback(false)
public void testSetStartDate() throws Exception { 
//TODO: Test goes here...
    List<League> leagueList=leagueService.getLeagueByStartDate("2018-05-20");
    for(League league:leagueList){
        league.setStartDate("2018-05-21");
        System.out.println("开始日期："+league.getStartDate());
    }
} 

/** 
* 
* Method: getEndDate() 
* 
*/ 
@Test
public void testGetEndDate() throws Exception { 
//TODO: Test goes here...
    List<League> leagueList=leagueService.getLeagueByStartDate("2018-05-21");
    for(League league:leagueList){
        System.out.println("结束日期："+league.getEndDate());
    }
} 

/** 
* 
* Method: setEndDate(String endDate) 
* 
*/ 
@Test
@Transactional
@Rollback(false)
public void testSetEndDate() throws Exception { 
//TODO: Test goes here...
    List<League> leagueList=leagueService.getLeagueByStartDate("2018-05-21");
    for(League league:leagueList){
        league.setEndDate("2018-05-30");
        System.out.println("结束日期："+league.getEndDate());
    }
} 

/** 
* 
* Method: getSponsor() 
* 
*/ 
@Test
public void testGetSponsor() throws Exception { 
//TODO: Test goes here...
    List<League> leagueList=leagueService.getLeagueBySponsor("西班牙");
    for(League league:leagueList){
        System.out.println("主办方："+league.getSponsor());
    }
} 

/** 
* 
* Method: setSponsor(String sponsor) 
* 
*/ 
@Test
@Transactional
@Rollback(false)
public void testSetSponsor() throws Exception { 
//TODO: Test goes here...
    List<League> leagueList=leagueService.getLeagueBySponsor("test1");
    for(League league:leagueList){
        league.setSponsor("test");
        System.out.println("主办方："+league.getSponsor());
    }
} 

/** 
* 
* Method: getConstitution() 
* 
*/ 
@Test
public void testGetConstitution() throws Exception { 
//TODO: Test goes here...
    League league=leagueService.getLeagueByName("test");
    System.out.println("联赛章程："+league.getConstitution());
} 

/** 
* 
* Method: setConstitution(String constitution) 
* 
*/ 
@Test
@Transactional
@Rollback(false)
public void testSetConstitution() throws Exception { 
//TODO: Test goes here...
} 

/** 
* 
* Method: getLevel() 
* 
*/ 
@Test
public void testGetLevel() throws Exception { 
//TODO: Test goes here...
    League league=leagueService.getLeagueByName("test");
    System.out.println("赛事性质："+league.getLevel());
} 

/** 
* 
* Method: setLevel(String level) 
* 
*/ 
@Test
@Transactional
@Rollback(false)
public void testSetLevel() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getGender() 
* 
*/ 
@Test
public void testGetGender() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setGender(String gender) 
* 
*/ 
@Test
@Transactional
@Rollback(false)
public void testSetGender() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getNumber() 
* 
*/ 
@Test
public void testGetNumber() throws Exception { 
//TODO: Test goes here...
    League league=leagueService.getLeagueByName("test");
    System.out.println("几人制联赛："+league.getNumber());
} 

/** 
* 
* Method: setNumber(int number) 
* 
*/ 
@Test
@Transactional
@Rollback(false)
public void testSetNumber() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getHalfTime() 
* 
*/ 
@Test
public void testGetHalfTime() throws Exception { 
//TODO: Test goes here...
    League league=leagueService.getLeagueByName("test");
    System.out.println("半场时间："+league.getHalfTime());
} 

/** 
* 
* Method: setHalfTime(String halfTime) 
* 
*/ 
@Test
@Transactional
@Rollback(false)
public void testSetHalfTime() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getHalfRelaxTime() 
* 
*/ 
@Test
public void testGetHalfRelaxTime() throws Exception { 
//TODO: Test goes here...
    League league=leagueService.getLeagueByName("test");
    System.out.println("半场休息时间："+league.getHalfRelaxTime());
} 

/** 
* 
* Method: setHalfRelaxTime(String halfRelaxTime) 
* 
*/ 
@Test
@Transactional
@Rollback(false)
public void testSetHalfRelaxTime() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getAbstentionScore() 
* 
*/ 
@Test
public void testGetAbstentionScore() throws Exception { 
//TODO: Test goes here...
    League league=leagueService.getLeagueByName("test");
    System.out.println("弃权默认比分："+league.getAbstentionScore());
} 

/** 
* 
* Method: setAbstentionScore(String abstentionScore) 
* 
*/ 
@Test
@Transactional
@Rollback(false)
public void testSetAbstentionScore() throws Exception { 
//TODO: Test goes here... 
} 


} 
