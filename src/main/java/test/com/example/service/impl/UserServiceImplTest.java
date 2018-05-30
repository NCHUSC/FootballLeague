package test.com.example.service.impl; 

import com.example.FootballleagueManagementsystemApplication;
import com.example.model.User;
import com.example.service.UserService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.swing.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/** 
* UserServiceImpl Tester. 
* 
* @author <Hurley>
* @since <pre>五月 25, 2018</pre> 
* @version 1.0 
*/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FootballleagueManagementsystemApplication.class)
@WebAppConfiguration
public class UserServiceImplTest { 

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
* Method: saveUser(User user) 
* 
*/ 
@Test
@Transactional
@Rollback(false)
public void testsaveUser() throws Exception {
//TODO: Test goes here...
    //测试插入第1条数据
    User user1=new User();
    user1.setAccount("test1");
    user1.setPassword("test1");
    user1.setTel("13657936306");
    userService.saveUser(user1);
    //测试插入第2条数据
    User user2=new User();
    user2.setAccount("test2");
    user2.setPassword("test2");
    user2.setTel("13657936306");
    userService.saveUser(user2);
}

/** 
* 
* Method: deleteUser(int user_id) 
* 
*/ 
@Test
@Transactional
@Rollback(false)
public void testDeleteUser() throws Exception { 
//TODO: Test goes here...
    //测试删除1条数据
    userService.deleteUser(16);
} 

/** 
* 
* Method: modifyUser(User user) 
* 
*/ 
@Test
@Transactional
@Rollback(false)
public void testModifyUser() throws Exception { 
//TODO: Test goes here...
    //测试修改1条数据
    User user=userService.getUserById(43);
    user.setAccount("test");
    user.setPassword("test");
    user.setTel("13657936306");
    userService.modifyUser(user);
} 

/** 
* 
* Method: getUserById(int user_id) 
* 
*/ 
@Test
public void testGetUserById() throws Exception { 
//TODO: Test goes here...
    //测试通过id获取数据
    User user=userService.getUserById(43);
    System.out.println("用户id："+user.getUser_id()+
                        "\n用户账号："+user.getAccount()+
                        "\n用户密码："+user.getPassword()+
                        "\n用户联系方式："+user.getTel());
} 

/** 
* 
* Method: getUserByAccount(String account) 
* 
*/ 
@Test
public void testGetUserByAccount() throws Exception { 
//TODO: Test goes here...
    //测试通过账号获取数据
    User user=userService.getUserByAccount("admin");
    System.out.println("用户id："+user.getUser_id()+
            "\n用户账号："+user.getAccount()+
            "\n用户密码："+user.getPassword()+
            "\n用户联系方式："+user.getTel());
} 

/** 
* 
* Method: userList() 
* 
*/ 
@Test
public void testUserList() throws Exception { 
//TODO: Test goes here...
    //测试获取数据库中所有用户列表
    for(User user:userService.userList()){
        System.out.println("用户id："+user.getUser_id()+"，用户账号："+user.getAccount());
    }
} 


} 
