package com.example.mapper;

import com.example.model.Photo;
import com.example.model.Player;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;
import java.util.List;

public interface PhotoMapper {

    /**
     * 通过保存后的完整文件名查询
     *
     * @param fileName
     * @return
     */
    @Select("select * from photo where fileName=#{fileName}")
    public Collection<Photo> selectPhotoByFileName(String fileName);

    /**
     * 通过所属联赛 ID 查询出某个联赛的所有图片
     *
     * @param leagueID
     * @return
     */
    @Select("select * from photo where leagueID=#{leagueID}")
    public Collection<Photo> selectPhotoByLeagueID(int leagueID);

    /**
     * 通过上传日期查询所有图片
     *
     * @param uploadDate
     * @return
     */
    @Select("select * from photo where uploadDate=#{uploadDate}")
    public Collection<Photo> selectPhotoByUploadDate(String uploadDate);
}
