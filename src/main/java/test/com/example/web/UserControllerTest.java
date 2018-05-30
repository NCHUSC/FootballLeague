package test.com.example.web; 

import com.example.FootballleagueManagementsystemApplication;
import com.example.model.User;
import com.example.service.UserService;
import com.example.web.UserController;
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
import org.springframework.test.web.servlet.MockMvcBuilder;
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
* UserController Tester. 
* 
* @author <Hurley>
* @since <pre>五月 24, 2018</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FootballleagueManagementsystemApplication.class)
@WebAppConfiguration
public class UserControllerTest { 

    @Autowired
    private UserController userController;

    @Autowired
    private UserService userService;

    private MockMvc mockMvc;

@Before
public void before() throws Exception {
    mockMvc=MockMvcBuilders.standaloneSetup(userController).build();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: list(Model model) 
* 
*/ 
@Test
public void testList() throws Exception { 
//TODO: Test goes here...
    List<User> users=new ArrayList<>();
    for(User user:userService.userList()){
        users.add(user);
        System.out.println("用户id："+user.getUser_id()+"，用户账号："+user.getAccount());
    }
} 

/** 
* 
* Method: toRegisterPage(Model model) 
* 
*/ 
@Test
public void testToRegisterPage() throws Exception { 
//TODO: Test goes here...

} 

/** 
* 
* Method: register(User user1, Map<String,Object> map) 
* 
*/ 
@Test
public void testRegister() throws Exception { 
//TODO: Test goes here...
} 

/** 
* 
* Method: modifyUser(User user) 
* 
*/ 
@Test
public void testModifyUser() throws Exception { 
//TODO: Test goes here... 
} 


/** 
* 
* Method: userList() 
* 
*/ 
@Test
public void testUserList() throws Exception { 
//TODO: Test goes here...
} 

} 
