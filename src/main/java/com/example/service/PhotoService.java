package com.example.service;

import com.example.model.Photo;

import java.util.Collection;
import java.util.List;

public interface PhotoService {

    //通过保存后的完整文件名查询
    Collection<Photo> getPhotoByFileName(String fileName);

    //通过所属联赛ID查询出某个联赛的所有图片
    Collection<Photo> getPhotoByLeagueID(int leagueID);

    //通过上传日期查询所有图片
    Collection<Photo> getPhotoByUploadDate(String uploadDate);
}
