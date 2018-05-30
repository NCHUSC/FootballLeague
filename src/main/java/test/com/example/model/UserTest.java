package test.com.example.model; 

import com.example.FootballleagueManagementsystemApplication;
import com.example.model.User;
import com.example.service.UserService;
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

/** 
* User Tester. 
* 
* @author <Hurley>
* @since <pre>五月 25, 2018</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FootballleagueManagementsystemApplication.class)
@WebAppConfiguration
public class UserTest { 

    @Autowired
    private UserService userService;

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getUser_id() 
* 
*/ 
@Test
public void testGetUser_id() throws Exception { 
//TODO: Test goes here...
    User user=userService.getUserById(43);
    System.out.println("用户id："+user.getUser_id());
} 

/** 
* 
* Method: setUser_id(int user_id) 
* 
*/ 
@Test
@Transactional
@Rollback(false)
public void testSetUser_id() throws Exception { 
//TODO: Test goes here...
} 

/** 
* 
* Method: getAccount() 
* 
*/ 
@Test
public void testGetAccount() throws Exception { 
//TODO: Test goes here...
    User user=userService.getUserByAccount("test");
    System.out.println("用户账号："+user.getAccount());
} 

/** 
* 
* Method: setAccount(String account) 
* 
*/ 
@Test
@Transactional
@Rollback(false)
public void testSetAccount() throws Exception { 
//TODO: Test goes here...
    User user=userService.getUserByAccount("admin2");
    user.setAccount("admin1");
    System.out.println("用户账号："+user.getAccount());
} 

/** 
* 
* Method: getPassword() 
* 
*/ 
@Test
public void testGetPassword() throws Exception { 
//TODO: Test goes here...
    User user=userService.getUserByAccount("test");
    System.out.println("用户密码："+user.getPassword());
} 

/** 
* 
* Method: setPassword(String password) 
* 
*/ 
@Test
@Transactional
@Rollback(false)
public void testSetPassword() throws Exception { 
//TODO: Test goes here...
    User user=userService.getUserByAccount("admin3");
    user.setPassword("test");
    System.out.println("用户密码："+user.getPassword());
} 

/** 
* 
* Method: getNickname() 
* 
*/ 
@Test
public void testGetNickname() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setNickname(String nickname) 
* 
*/ 
@Test
public void testSetNickname() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getTel() 
* 
*/ 
@Test
public void testGetTel() throws Exception { 
//TODO: Test goes here...
    User user=userService.getUserByAccount("test");
    System.out.println("联系方式："+user.getTel());
} 

/** 
* 
* Method: setTel(String tel) 
* 
*/ 
@Test
@Transactional
@Rollback(false)
public void testSetTel() throws Exception { 
//TODO: Test goes here...
    User user=userService.getUserByAccount("admin3");
    user.setTel("13247916236");
    System.out.println("联系方式："+user.getTel());
} 


} 
