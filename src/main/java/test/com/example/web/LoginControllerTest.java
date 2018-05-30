package test.com.example.web; 

import com.example.FootballleagueManagementsystemApplication;
import com.example.web.LoginController;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/** 
* LoginController Tester. 
* 
* @author <Hurley>
* @since <pre>五月 24, 2018</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FootballleagueManagementsystemApplication.class)
@WebAppConfiguration
public class LoginControllerTest { 

    @Autowired
    private LoginController loginController;

    private MockMvc mockMvc;

@Before
public void before() throws Exception {
    mockMvc=MockMvcBuilders.standaloneSetup(loginController).build();
} 

@After
public void after() throws Exception { 
}

/** 
* 
* Method: login(User user1, Map<String,Object> map, HttpSession session) 
* 
*/ 
@Test
public void testLogin() throws Exception { 
//TODO: Test goes here...
        mockMvc.perform(MockMvcRequestBuilders.post("/login").accept(MediaType.APPLICATION_JSON)
                .param("account","account")
                .param("password","yzheng520")
        )
                .andExpect(MockMvcResultMatchers.view().name("redirect:/index.html"));

}


} 
