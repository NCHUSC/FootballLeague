package test.com.example.model; 

import com.example.FootballleagueManagementsystemApplication;
import com.example.model.Photo;
import com.example.repository.PhotoRepository;
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
* Photo Tester. 
* 
* @author <Hurley>
* @since <pre>五月 28, 2018</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FootballleagueManagementsystemApplication.class)
@WebAppConfiguration
public class PhotoTest { 

    @Autowired
    private PhotoRepository photoRepository;

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getPhoto_id() 
* 
*/ 
@Test
public void testGetPhoto_id() throws Exception { 
//TODO: Test goes here...
    Photo photo=photoRepository.getOne(140);
    System.out.println("照片id："+photo.getPhoto_id());
} 

/** 
* 
* Method: setPhoto_id(int photo_id) 
* 
*/ 
@Test
public void testSetPhoto_id() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getUploadUser() 
* 
*/ 
@Test
public void testGetUploadUser() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setUploadUser(String uploadUser) 
* 
*/ 
@Test
public void testSetUploadUser() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getUploadDate() 
* 
*/ 
@Test
public void testGetUploadDate() throws Exception { 
//TODO: Test goes here...
    List<Photo> photoList=photoRepository.findByUploadDate("2018/05/22/");
    for(Photo photo:photoList){
        System.out.println("上传日期："+photo.getUploadDate());
    }
} 

/** 
* 
* Method: setUploadDate(String uploadDate) 
* 
*/ 
@Test
public void testSetUploadDate() throws Exception { 
//TODO: Test goes here...
    List<Photo> photoList=photoRepository.findByUploadDate("2018/05/24/");
    for(Photo photo:photoList){
        photo.setUploadDate("2018/05/23");
        System.out.println("上传日期："+photo.getUploadDate());
    }
}

/** 
* 
* Method: getIntroduction() 
* 
*/ 
@Test
public void testGetIntroduction() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setIntroduction(String introduction) 
* 
*/ 
@Test
public void testSetIntroduction() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getSrcFile() 
* 
*/ 
@Test
public void testGetSrcFile() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setSrcFile(String srcFile) 
* 
*/ 
@Test
public void testSetSrcFile() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getDestFile() 
* 
*/ 
@Test
public void testGetDestFile() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setDestFile(String destFile) 
* 
*/ 
@Test
public void testSetDestFile() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getFileName() 
* 
*/ 
@Test
public void testGetFileName() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setFileName(String fileName) 
* 
*/ 
@Test
public void testSetFileName() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getLeagueID() 
* 
*/ 
@Test
public void testGetLeagueID() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setLeagueID(int leagueID) 
* 
*/ 
@Test
public void testSetLeagueID() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getStaticPath() 
* 
*/ 
@Test
public void testGetStaticPath() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setStaticPath(String staticPath) 
* 
*/ 
@Test
public void testSetStaticPath() throws Exception { 
//TODO: Test goes here... 
} 


} 
