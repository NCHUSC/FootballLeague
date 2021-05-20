package com.example.repository;

import com.example.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {

    /**
     * 通过保存后的完整文件名查询
     *
     * @param fileName
     * @return
     */
    Photo findByFileName(String fileName);

    /**
     * 通过所属联赛ID查询出某个联赛的所有图片
     *
     * @param leagueID
     * @return
     */
    List<Photo> findByLeagueID(int leagueID);

    /**
     * 通过上传日期查询所有图片
     *
     * @param uploadDate
     * @return
     */
    List<Photo> findByUploadDate(String uploadDate);
}
