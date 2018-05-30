package test.com.example.web; 

import com.example.FootballleagueManagementsystemApplication;
import com.example.model.League;
import com.example.service.LeagueService;
import com.example.web.LeagueController;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/** 
* LeagueController Tester. 
* 
* @author <Hurley>
* @since <pre>五月 26, 2018</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FootballleagueManagementsystemApplication.class)
@WebAppConfiguration
public class LeagueControllerTest { 

    @Autowired
    private LeagueController leagueController;

    @Autowired
    private LeagueService leagueService;

    private MockMvc mockMvc;
    private MockHttpSession session;

@Before
public void before() throws Exception {
    mockMvc=MockMvcBuilders.standaloneSetup(leagueController).build();
    session=new MockHttpSession();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: leagueList() 
* 
*/ 
@Test
public void testLeagueList() throws Exception { 
//TODO: Test goes here...
    List<League> leagues=new ArrayList<>();
    for(League league:leagueService.leagueList()){
        leagues.add(league);
        System.out.println("联赛id："+league.getLeague_id()+"，联赛名称："+league.getLeagueName());
    }

} 

/** 
* 
* Method: toAddPage(Model model)
* 
*/ 
@Test
public void testToAddPage() throws Exception { 
//TODO: Test goes here...
    mockMvc.perform(MockMvcRequestBuilders.get("/league").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.view().name("league/addLeagueInformation"))
            .andDo(print());
            /*.andExpect(content().string(equalTo("")));*/
} 

/** 
* 
* Method: addLeagueInformation(League league, Model model, HttpSession session) 
* 
*/ 
@Test
public void testAddLeagueInformation() throws Exception {
//TODO: Test goes here...
    mockMvc.perform(MockMvcRequestBuilders.post("/league").accept(MediaType.APPLICATION_JSON)
            .param("leagueName","test2")
            .param("shorterName","test2")
            .param("startDate","2018-06-01")
            .param("endDate","2018-06-23")
            .param("sponsor","test2")
            .param("constitution","test2")
            .param("level","大学")
            .param("number","11")
            .param("halfTime","10分钟")
            .param("halfRelaxTime","20分钟")
            .param("abstentionScore","3:0(负)")
    )
            .andExpect(MockMvcResultMatchers.view().name("redirect:/leagues"));

} 

/** 
* 
* Method: toQueryPage(Model model) 
* 
*/ 
@Test
public void testToQueryPage() throws Exception { 
//TODO: Test goes here...
    mockMvc.perform(MockMvcRequestBuilders.get("/queryLeague").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.view().name("league/queryLeague"))
            .andDo(print());
            /*.andExpect(content().string(equalTo("")));*/
} 

/** 
* 
* Method: findById(League league1, Model model) 
* 
*/ 
@Test
public void testFindById() throws Exception { 
//TODO: Test goes here...
    mockMvc.perform(MockMvcRequestBuilders.post("/showLeagueById")
            .accept(MediaType.APPLICATION_JSON)
            .param("league_id","164")
    )
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.view().name("league/showLeague"));
} 

/** 
* 
* Method: findByName(League league1, Model model) 
* 
*/ 
@Test
public void testFindByName() throws Exception { 
//TODO: Test goes here...
    mockMvc.perform(MockMvcRequestBuilders.post("/showLeagueByName")
            .accept(MediaType.APPLICATION_JSON)
            .param("leagueName","test2")
    )
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.view().name("league/showLeague"));
} 

/** 
* 
* Method: findByShorterName(League league1, Model model) 
* 
*/ 
@Test
public void testFindByShorterName() throws Exception { 
//TODO: Test goes here...
    mockMvc.perform(MockMvcRequestBuilders.post("/showLeagueByShorterName")
            .accept(MediaType.APPLICATION_JSON)
            .param("shorterName","test2")
    )
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.view().name("league/showLeague"));
} 

/** 
* 
* Method: findByDate(League league1, Model model) 
* 
*/ 
@Test
public void testFindByDate() throws Exception { 
//TODO: Test goes here...
    mockMvc.perform(MockMvcRequestBuilders.post("/showLeagueByDate")
            .accept(MediaType.APPLICATION_JSON)
            .param("startDate","2018-06-01")
    )
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.view().name("league/showLeague"));
} 

/** 
* 
* Method: findBySponsor(League league, Model model) 
* 
*/ 
@Test
public void testFindBySponsor() throws Exception { 
//TODO: Test goes here...
    mockMvc.perform(MockMvcRequestBuilders.post("/showLeagueBySponsor")
            .accept(MediaType.APPLICATION_JSON)
            .param("sponsor","西班牙")
    )
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.view().name("league/showLeague"));
} 

/** 
* 
* Method: showLeagueDetails(int league_id, Model model) 
* 
*/ 
@Test
public void testShowLeagueDetails() throws Exception { 
//TODO: Test goes here...
    mockMvc.perform(MockMvcRequestBuilders.get("/showLeagueDetails")
            .accept(MediaType.APPLICATION_JSON)
            .param("league_id","164")
    )
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.view().name("league/showLeagueDetails"));
} 

/** 
* 
* Method: toModifyPage(int league_id, Model model) 
* 
*/ 
@Test
public void testToModifyPage() throws Exception { 
//TODO: Test goes here...
    mockMvc.perform(MockMvcRequestBuilders.get("/modifyLeague")
            .accept(MediaType.APPLICATION_JSON)
            .param("league_id","164")
    )
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.view().name("league/modifyLeague"));
} 

/** 
* 
* Method: modifyLeague(League league) 
* 
*/ 
@Test
public void testModifyLeague() throws Exception { 
//TODO: Test goes here...
} 

/** 
* 
* Method: deleteLeague(int league_id) 
* 
*/ 
@Test
public void testDeleteLeague() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: toLeaguesPage(Model model) 
* 
*/ 
@Test
public void testToLeaguesPage() throws Exception { 
//TODO: Test goes here...
    mockMvc.perform(MockMvcRequestBuilders.get("/leagues").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andDo(print())
            .andExpect(MockMvcResultMatchers.view().name("league/leagues"));

} 

/** 
* 
* Method: toAllAlbumsPage(Model model) 
* 
*/ 
@Test
public void testToAllAlbumsPage() throws Exception { 
//TODO: Test goes here...
    mockMvc.perform(MockMvcRequestBuilders.get("/albums").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andDo(print())
            .andExpect(MockMvcResultMatchers.view().name("album/albums"));
} 


} 
