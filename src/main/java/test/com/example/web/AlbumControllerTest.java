package test.com.example.web; 

import com.example.FootballleagueManagementsystemApplication;
import com.example.model.League;
import com.example.model.Photo;
import com.example.repository.PhotoRepository;
import com.example.web.AlbumController;
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

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/** 
* AlbumController Tester. 
* 
* @author <Hurley>
* @since <pre>五月 24, 2018</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FootballleagueManagementsystemApplication.class)
@WebAppConfiguration
public class AlbumControllerTest { 

    @Autowired
    private AlbumController albumController;

    @Autowired
    private PhotoRepository photoRepository;

    private MockMvc mockMvc;

@Before
public void before() throws Exception {
    mockMvc=MockMvcBuilders.standaloneSetup(albumController).build();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: photoList() 
* 
*/ 
@Test
public void testPhotoList() throws Exception { 
//TODO: Test goes here...
    List<Photo> photos=new ArrayList<>();
    for(Photo photo:photoRepository.findAll()){
        photos.add(photo);
        System.out.println("图片id："+photo.getPhoto_id()+"，图片名称："+photo.getFileName());
    }
} 

/** 
* 
* Method: photos(int leagueID) 
* 
*/ 
@Test
public void testPhotos() throws Exception { 
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
    mockMvc.perform(MockMvcRequestBuilders.get("/photoes").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.view().name("album/photoes"))
            .andDo(print());
} 

/** 
* 
* Method: toAddPhotoPage(int league_id, Model model, HttpSession session) 
* 
*/ 
@Test
public void testToAddPhotoPage() throws Exception { 
//TODO: Test goes here...
    mockMvc.perform(MockMvcRequestBuilders.get("/addPhoto")
            .accept(MediaType.APPLICATION_JSON)
            .param("league_id","94")
    )
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.view().name("album/addPhoto"));
} 

/** 
* 
* Method: toShowPhotoPage(int league_id, Model model) 
* 
*/ 
@Test
public void testToShowPhotoPage() throws Exception { 
//TODO: Test goes here...
    mockMvc.perform(MockMvcRequestBuilders.get("/showPhoto")
            .accept(MediaType.APPLICATION_JSON)
            .param("league_id","94")
    )
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.view().name("album/showPhoto"));
} 

/** 
* 
* Method: uploadImg(@RequestParam("file") MultipartFile file, HttpSession session, HttpServletRequest request) 
* 
*/ 
@Test
public void testUploadImg() throws Exception { 
//TODO: Test goes here... 
} 


} 
