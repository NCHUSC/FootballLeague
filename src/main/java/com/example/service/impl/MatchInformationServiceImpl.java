package com.example.service.impl;

import com.example.mapper.MatchInformationMapper;
import com.example.model.MatchInformation;
import com.example.service.MatchInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchInformationServiceImpl implements MatchInformationService {
    @Autowired
    MatchInformationMapper matchInformationMapper;

    @Override
    public int saveMatchInformation(MatchInformation matchInformation) {
        return matchInformationMapper.saveMatchInformation(matchInformation);
    }

    @Override
    public List<MatchInformation> getMatchInformationByLeague(String league) {
        return matchInformationMapper.getMatchInformationByLeague(league);
    }
}
