package test.com.example.service.impl; 

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
* LeagueServiceImpl Tester. 
* 
* @author <Hurley>
* @since <pre>五月 25, 2018</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FootballleagueManagementsystemApplication.class)
@WebAppConfiguration
public class LeagueServiceImplTest { 

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
* Method: saveLeague(League league) 
* 
*/
@Test
@Transactional
@Rollback(false)
public void testSaveLeague() throws Exception { 
//TODO: Test goes here...
    //测试插入第1条数据
    League league1=new League();
    league1.setLeagueName("test1");
    league1.setShorterName("test1");
    league1.setStartDate("2018-06-01");
    league1.setEndDate("2018-06-23");
    league1.setSponsor("test1");
    league1.setConstitution("test1");
    league1.setLevel("大学");
    league1.setHalfTime("10分钟");
    league1.setHalfRelaxTime("30分钟");
    league1.setAbstentionScore("1:0(负)");
    leagueService.saveLeague(league1);
    //测试插入第2条数据
    League league2=new League();
    league2.setLeagueName("test2");
    league2.setShorterName("test2");
    league2.setStartDate("2018-07-01");
    league2.setEndDate("2018-07-23");
    league2.setSponsor("test1");
    league2.setConstitution("test2");
    league2.setLevel("大学");
    league2.setHalfTime("10分钟");
    league2.setHalfRelaxTime("30分钟");
    league2.setAbstentionScore("1:0(负)");
    leagueService.saveLeague(league2);
} 

/** 
* 
* Method: deleteLeague(int league_id) 
* 
*/ 
@Test
@Transactional
@Rollback(false)
public void testDeleteLeague() throws Exception { 
//TODO: Test goes here...
    //测试删除1条数据
    leagueService.deleteLeague(165);
} 

/** 
* 
* Method: modifyLeague(League league) 
* 
*/ 
@Test
@Transactional
@Rollback(false)
public void testModifyLeague() throws Exception { 
//TODO: Test goes here...
    //测试修改1条数据
    League league=leagueService.getLeaugeById(94);
    league.setLeagueName("test2");
    league.setShorterName("test2");
    league.setConstitution("test2");
    league.setLevel("大学");
    leagueService.saveLeague(league);
} 

/** 
* 
* Method: getLeaugeById(int league_id) 
* 
*/ 
@Test
public void testGetLeaugeById() throws Exception { 
//TODO: Test goes here...
    //测试通过id获取数据
    League league=leagueService.getLeaugeById(158);
    System.out.println("联赛id："+league.getLeague_id());
    /*System.out.println("联赛id："+league.getLeague_id()+
            "\n联赛名称："+league.getLeagueName()+
            "\n联赛简称："+league.getShorterName()+
            "\n开始日期："+league.getStartDate()+
            "\n结束日期："+league.getEndDate());*/
} 

/** 
* 
* Method: getLeagueByName(String leagueName) 
* 
*/ 
@Test
public void testGetLeagueByName() throws Exception { 
//TODO: Test goes here...
    //测试通过联赛名称获取数据
    League league=leagueService.getLeagueByName("test1");
    System.out.println("联赛id："+league.getLeague_id()+
                        "\n联赛名称："+league.getLeagueName());
} 

/** 
* 
* Method: getLeagueByNameLike(String leagueName) 
* 
*/ 
@Test
public void testGetLeagueByNameLike() throws Exception { 
//TODO: Test goes here...
    //测试通过联赛名称模糊查询获取数据
    List<League> leagueList=leagueService.getLeagueByNameLike("test");
    for(League league:leagueList){
        System.out.println("联赛id："+league.getLeague_id()+"，联赛名称："+league.getLeagueName());
    }

} 

/** 
* 
* Method: getLeagueByShorterName(String shorterName) 
* 
*/ 
@Test
public void testGetLeagueByShorterName() throws Exception { 
//TODO: Test goes here...
    //测试通过联赛简称获取数据
    League league=leagueService.getLeagueByShorterName("test1");
    System.out.println("联赛id："+league.getLeague_id()+
            "\n联赛名称："+league.getLeagueName());
} 

/** 
* 
* Method: getLeagueByShorterNameLike(String shorterName) 
* 
*/ 
@Test
public void testGetLeagueByShorterNameLike() throws Exception { 
//TODO: Test goes here...
    //测试通过联赛简称模糊查询获取数据
    List<League> leagueList=leagueService.getLeagueByShorterNameLike("联赛");
    for(League league:leagueList){
        System.out.println("联赛id："+league.getLeague_id()+"，联赛名称："+league.getLeagueName()+"，联赛简称："+league.getShorterName());
    }
} 

/** 
* 
* Method: getLeagueByStartDate(String startDate) 
* 
*/ 
@Test
public void testGetLeagueByStartDate() throws Exception { 
//TODO: Test goes here...
    //测试通过开始日期获取数据
    List<League> leagueList=leagueService.getLeagueByStartDate("2018-05-20");
    for(League league:leagueList){
        System.out.println("联赛id："+league.getLeague_id()+"，联赛名称："+league.getLeagueName());
    }
} 

/** 
* 
* Method: getLeagueBySponsor(String sponsor) 
* 
*/ 
@Test
public void testGetLeagueBySponsor() throws Exception { 
//TODO: Test goes here...
    //测试通过主办方获取数据
    List<League> leagueList=leagueService.getLeagueBySponsor("土建学院");
    for(League league:leagueList){
        System.out.println("联赛id："+league.getLeague_id()+"，联赛名称："+league.getLeagueName());
    }
} 

/** 
* 
* Method: getLeagueBySponsorLike(String sponsor) 
* 
*/ 
@Test
public void testGetLeagueBySponsorLike() throws Exception { 
//TODO: Test goes here...
    List<League> leagueList=leagueService.getLeagueBySponsorLike("协会");
    for(League league:leagueList){
        System.out.println("联赛id："+league.getLeague_id()+"，联赛名称："+league.getLeagueName()+"，主办方："+league.getSponsor());
    }
} 

/** 
* 
* Method: leagueList() 
* 
*/ 
@Test
public void testLeagueList() throws Exception { 
//TODO: Test goes here...
    //测试获取数据库中所有联赛列表
    for(League league:leagueService.leagueList()){
        System.out.println("联赛id："+league.getLeague_id()+"，联赛名称："+league.getLeagueName());
    }
} 


} 
