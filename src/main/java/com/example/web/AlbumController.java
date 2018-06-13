package com.example.web;

import com.example.model.League;
import com.example.model.Photo;
import com.example.repository.LeagueRepository;
import com.example.repository.PhotoRepository;
import com.example.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class AlbumController {

    @Autowired
    private LeagueRepository leagueRepository;

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private PhotoService photoService;

    /**
     * 从数据库中获取所有图片
     * @return
     */
    public List<Photo> photoList(){
        List<Photo> photos=new ArrayList<>();
        for(Photo photo:photoRepository.findAll()){
            photos.add(photo);
        }
        return photos;
    }

    /**
     * 从数据库中获取所有属于该联赛ID的图片
     * @param leagueID
     * @return
     */
    public List<Photo> photos(int leagueID){
        List<Photo> photos=new ArrayList<>();
        for(Photo photo:photoService.getPhotoByLeagueID(leagueID)){
            photos.add(photo);
        }
        return photos;
    }

    //获取数据库中的所有图片
    @GetMapping("/photoes")
    public ModelAndView toLeaguesPage(Model model){
        model.addAttribute("photoList",photoList());
        return new ModelAndView("album/photoes","photoModel",model);
    }

    //跳转至所有联赛相册信息页面
    /*@GetMapping("/albums")
    public ModelAndView toAllAlbumsPage(Model model){
        model.addAttribute("leagueList",leagueController.leagueList());
        return new ModelAndView("album/albums","leagueModel",model);
    }*/

    //跳转至上传照片页面
    @GetMapping("/addPhoto")
    public String toAddPhotoPage(int league_id,Model model,HttpSession session){
        League league=leagueRepository.getOne(league_id);
        System.out.println(league_id);
        model.addAttribute("league",league);
        session.setAttribute("leagueID",league_id);
        return "album/addPhoto";
    }

    //跳转至查看照片页面
    @GetMapping("/showPhoto")
    public ModelAndView toShowPhotoPage(int league_id,Model model /*HttpServletRequest request*/){
        League league=leagueRepository.getOne(league_id);
        /*String fileName=request.getSession().getAttribute("fileName").toString();*/
        /*System.out.println("文件名称啊啊啊:"+fileName);*/
        model.addAttribute("league",league);
        /*Photo photo=photoRepository.findByFileName(fileName);*/
        List<Photo> photos=photoRepository.findByLeagueID(league_id);
        model.addAttribute("photo",photos);
        model.addAttribute("photoList",photos(league_id));
        return new ModelAndView("album/showPhoto","photoModel",model);
        /*return "album/showPhoto";*/
    }

    //上传照片
    @RequestMapping(value = "/addPhoto",method = RequestMethod.POST)
    public @ResponseBody String uploadImg(@RequestParam("file") MultipartFile file,HttpSession session,
                                          HttpServletRequest request) {

        Photo photo=new Photo();

        String str="";

        String league_id=request.getSession().getAttribute("leagueID").toString();

        System.out.println("联赛id："+league_id);

        String url=request.getRequestURI();
        System.out.println("URL:"+url);

        /*String number=request.getQueryString();
        System.out.println("参数："+number);*/

        try {
            if(null!=file){
                //获得当前项目所在路径
                String pathRoot=request.getSession().getServletContext().getRealPath("");
                System.out.println("当前项目所在路径："+pathRoot);
                //生成uuid作为文件名称
                String uuid=UUID.randomUUID().toString().replaceAll("-","");
                System.out.println("文件名称："+uuid);
                //获得文件类型（判断如果不是图片文件类型，则禁止上传）
                String contentType=file.getContentType();
                System.out.println("文件类型："+contentType);
                //获得文件后缀名称
                String imageName=contentType.substring(contentType.indexOf("/")+1);
                System.out.println("文件后缀名称："+imageName);

                String filePath="/Users/hurley/Desktop/footballleague-managementsystem/src/main/resources/static/upload/images/";
                //根据日期来创建对应的文件夹
                String datePath=new SimpleDateFormat("yyyy/MM/dd/").format(new Date());
                System.out.println("日期："+datePath);
                //根据id分类来创建对应的文件夹
                String leagueIdPath=league_id+"/";

                //日期
                /*String path=filePath+datePath;*/
                //联赛id
                String path=filePath+leagueIdPath;

                //如果不存在，则创建新文件夹
                File f=new File(path);
                if(!f.exists()){
                    f.mkdirs();
                }

                //新生成的文件名称
                String fileName=uuid+"."+imageName;
                System.out.println("新生成的文件名称："+fileName);
                session.setAttribute("fileName",fileName);

                //图片保存的完整路径
                String pathName=path+fileName;
                System.out.println(pathName);

                /*session.setAttribute("pathName",pathName);*/


                /*String[] ss=new String[20];
                ss=pathName.split("/");
                for(int i=0;i<ss.length;i++){
                    System.out.println(ss[i]);
                }
                int leagueID=Integer.parseInt(ss[11]);
                System.out.println("截取的所属联赛id为："+ss[11]);*/


                //获取所属联赛ID
                int leagueID=Integer.parseInt(league_id);

                //图片的静态资源路径
                String staticPath="/upload/images/"+leagueID+"/"+fileName;
                System.out.println("静态资源路径："+staticPath);
                session.setAttribute("staticPath",staticPath);

                /*//若图片大于10M，则禁止上传
                if(file.getSize()>=10*1024*1024){
                    str = "{\"code\": 1,\"msg\": \"上传图片不能大于10M\"}";
                    return str;
                }
                else if(file.getSize()>=1*1024*1024){
                    //若图片大于1M小于10M，对其进行压缩后上传

                    //复制操作
                    //将图片从源位置复制到目标位置
                    file.transferTo(new File(pathName));
                    //图片尺寸不变，压缩图片文件大小outputQuality实现，参数1为最高质量
                    //第一个pathName=fromPic，第二个pathName=toPic，两者写成同样的路径和文件名，代表直接替换

                    //生成压缩后的图片，并对上面保存的原文件图片进行覆盖
                }*/

                //复制操作
                //将图片从源位置复制到目标位置
                file.transferTo(new File(pathName));

                str = "{\"code\": 0,\"msg\": \"\",\"data\": {\"src\":\"" + "pic/"+datePath+fileName + "\"}}";

                photo.setStaticPath(staticPath);    //将图片保存的静态资源路径插入数据库
                photo.setLeagueID(leagueID);        //将所属联赛ID插入数据库
                photo.setUploadDate(datePath);      //将上传日期插入数据库
                photo.setDestFile(pathName);        //将完整路径插入数据库
                photo.setFileName(fileName);        //将最后保存的完整文件名插入数据库
                photoRepository.save(photo);
            }
            else{
                System.out.println("文件为空");
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            return str;
        }



        //图片能够保存到指定文件夹中，但是页面无法跳转，并报错：
        //Error resolving template "static/upload/images/63073a29.jpg", template might not exist or might not be accessible by any of the configured Template Resolvers
        /*
        if (null != file) {
            String myFileName = file.getOriginalFilename();             // 文件原名称
            System.out.println(myFileName);
            String fileName=Integer.toHexString(new Random().nextInt())+myFileName.substring(myFileName.lastIndexOf("."));
            System.out.println(fileName);                               //文件后缀名
            *//*String fileName = "/Users/hurley/Desktop/footballleague-managementsystem/src/main/resources/static/upload/images";*//*
            String pat="/Users/hurley/Desktop/footballleague-managementsystem/src/main/resources/";
            String sqlPath="static/upload/images/";                     //获取文件保存路径
                    *//*FileProperties.getFilePath()+"/src/main/webapp/";*//*
            *//*String sqlPath="";*//*
                    *//*"static/images/upload/storeHead/"+BasePath.getImgPath("yyyyMMdd")+"/";*//*
            System.out.println("路径是对的！");
            File fileDir=new File(pat+sqlPath);
            if (!fileDir.exists()) {                                    //如果不存在 则创建
                fileDir.mkdirs();
            }
            String path=pat+sqlPath+fileName;
            File localFile = new File(path);
            try {
                file.transferTo(localFile);
                return sqlPath+fileName;
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("文件为空");
        }
        return null;
        */
    }


}
















