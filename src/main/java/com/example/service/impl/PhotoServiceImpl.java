package com.example.service.impl;

import com.example.mapper.PhotoMapper;
import com.example.model.Photo;
import com.example.repository.PhotoRepository;
import com.example.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoMapper photoMapper;

    @Override
    public Collection<Photo> getPhotoByFileName(String fileName) {
        return photoMapper.selectPhotoByFileName(fileName);
    }

    @Override
    public Collection<Photo> getPhotoByLeagueID(int leagueID) {
        return photoMapper.selectPhotoByLeagueID(leagueID);
    }

    @Override
    public Collection<Photo> getPhotoByUploadDate(String uploadDate) {
        return photoMapper.selectPhotoByUploadDate(uploadDate);
    }
}
